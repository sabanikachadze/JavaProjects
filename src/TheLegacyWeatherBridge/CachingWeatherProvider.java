package TheLegacyWeatherBridge;

import java.util.HashMap;
import java.util.Map;

public class CachingWeatherProvider implements WeatherProvider {

    private static final long TTL_MS = 60_000; // 60 seconds

    private final WeatherProvider provider;

    private final Map<String, CacheEntry> cache = new HashMap<>();

    private record CacheEntry(WeatherReading reading, long cachedAt) {
        boolean isExpired() {
            return System.currentTimeMillis() - cachedAt > TTL_MS;
        }
    }

    public CachingWeatherProvider(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    public WeatherReading getCurrentWeather(String city) throws WeatherUnavailableException {
        String key = city.toLowerCase().trim();

        CacheEntry entry = cache.get(key);

        if (entry != null && !entry.isExpired()) {
            System.out.println("  [cache] returning cached result for: " + city);
            return entry.reading();
        }

        System.out.println("  [live]  fetching fresh data for: " + city);
        WeatherReading fresh = provider.getCurrentWeather(city);

        cache.put(key, new CacheEntry(fresh, System.currentTimeMillis()));
        return fresh;
    }
}
