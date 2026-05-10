package TheLegacyWeatherBridge;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public interface WeatherProvider {


    WeatherReading getCurrentWeather(String city) throws WeatherUnavailableException;

    default Map<String, WeatherReading> getAll(List<String> cities) {
        return cities.stream()
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
}