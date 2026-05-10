package TheLegacyWeatherBridge;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LegacyWeatherStation station  = new LegacyWeatherStation();
        WeatherProvider       adapter = new LegacyWeatherAdapter(station);
        WeatherProvider       weather = new CachingWeatherProvider(adapter);

        // ── Single city fetches — cache miss then hit ──────────────────────
        System.out.println("═".repeat(55));
        System.out.println(" Single fetch — first call (cache miss)");
        System.out.println("═".repeat(55));

        try {
            System.out.println(weather.getCurrentWeather("tbilisi"));
        } catch (WeatherUnavailableException e) {
            System.out.println("Unavailable: " + e.getMessage());
        }

        System.out.println("\n Second call — same city (cache hit)");
        System.out.println("─".repeat(55));

        try {
            System.out.println(weather.getCurrentWeather("tbilisi"));
        } catch (WeatherUnavailableException e) {
            System.out.println("Unavailable: " + e.getMessage());
        }

        // ── Bulk fetch — valid cities + one unknown mixed in ───────────────
        System.out.println("\n" + "═".repeat(55));
        System.out.println(" Bulk fetch — getAll() with one bad city mixed in");
        System.out.println("═".repeat(55));

        var cities = List.of("new york", "london", "atlantis", "tokyo", "berlin");
        var results = weather.getAll(cities);

        System.out.println("\n Results (" + results.size() + "/" + cities.size() + " cities returned):");
        System.out.println("─".repeat(55));
        results.forEach((city, reading) -> System.out.println(reading));

        // ── Unknown city — single fetch ────────────────────────────────────
        System.out.println("\n" + "═".repeat(55));
        System.out.println(" Unknown city — single fetch");
        System.out.println("═".repeat(55));

        try {
            weather.getCurrentWeather("atlantis");
        } catch (WeatherUnavailableException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}