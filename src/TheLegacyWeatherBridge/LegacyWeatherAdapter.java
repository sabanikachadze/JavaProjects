package TheLegacyWeatherBridge;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LegacyWeatherAdapter implements WeatherProvider {

    private final LegacyWeatherStation legacy;

    private static final Map<String, String> CONDITION_CODES = Map.of(
        "S",  "SUNNY",
        "PC", "PARTLY_CLOUDY",
        "C",  "CLOUDY",
        "O",  "OVERCAST",
        "R",  "RAINY",
        "SR", "SHOWERS",
        "T",  "THUNDERSTORM",
        "SN", "SNOWY",
        "SL", "SLEET",
        "H",  "HAIL"
    );

    public LegacyWeatherAdapter(LegacyWeatherStation legacy) {
        this.legacy = legacy;
    }

    @Override
    public WeatherReading getCurrentWeather(String city) throws WeatherUnavailableException {
        try {
            String rawData = legacy.fetchWeatherCsv(city);
            String[] parts = rawData.split(",");

            String cityName = toTitleCase(parts[0]);
            double celsius = (Double.parseDouble(parts[1]) - 32) * 5.0 / 9.0;
            double kph = Double.parseDouble(parts[2]) * 1.609344;

            String condition = CONDITION_CODES.get(parts[3]);
            if (condition == null) {
                throw new WeatherUnavailableException(
                    "Unrecognized condition code from legacy station: " + parts[3]
                );
            }

            return new WeatherReading(cityName, celsius, kph, condition);

        } catch (LegacyServiceException e) {
            throw new WeatherUnavailableException(
                "Legacy station has no data for city: " + city, e
            );
        }
    }

    @Override
    public Map<String, WeatherReading> getAll(List<String> cities) {
        return cities.parallelStream()
            .flatMap(city -> {
                try {
                    return Stream.of(Map.entry(city, getCurrentWeather(city)));
                } catch (WeatherUnavailableException e) {
                    System.out.println("  [skip] " + city + ": " + e.getMessage());
                    return Stream.empty();
                }
            })
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static String toTitleCase(String input) {
        if (input == null || input.isBlank()) return input;
        return Arrays.stream(input.trim().split("\\s+"))
                     .map(LegacyWeatherAdapter::capitalize)
                     .collect(Collectors.joining(" "));
    }

    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) return word;
        return Character.toUpperCase(word.charAt(0))
             + word.substring(1).toLowerCase();
    }
}