package TheLegacyWeatherBridge;

public class Main {

    public static void main(String[] args) {
        LegacyWeatherStation station = new LegacyWeatherStation();

        WeatherProvider weather = new LegacyWeatherAdapter(station);

        String[] cities = { "tbilisi", "new york", "london", "tokyo", "berlin" };

        System.out.println("─".repeat(55));
        System.out.printf("%-15s | %-7s | %-10s | %s%n",
            "City", "Temp", "Wind", "Condition");
        System.out.println("─".repeat(55));

        for (var city : cities) {
            try {
                System.out.println(weather.getCurrentWeather(city));
            } catch (WeatherUnavailableException e) {
                System.out.printf("%-15s | %s%n", city, e.getMessage());
            }
        }

        System.out.println("─".repeat(55));

        System.out.println("\nTesting unknown city:");
        try {
            weather.getCurrentWeather("atlantis");
        } catch (WeatherUnavailableException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}