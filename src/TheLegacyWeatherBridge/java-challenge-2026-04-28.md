# The Legacy Weather Bridge

**Topic:** Object-Oriented Programming & Design Patterns (Adapter Pattern)

**Difficulty:** Intermediate

**Estimated time:** 35–50 minutes

---

## Problem statement

Your team has been asked to integrate weather data into a brand-new mobile app. The app's frontend already calls a clean, modern interface called `WeatherProvider` that returns simple, well-structured data. Unfortunately, the only weather feed your company is allowed to use comes from a 12-year-old internal service called `LegacyWeatherStation` — it returns ugly, comma-separated strings, uses Fahrenheit, and was written long before generics were popular.

You can't modify the legacy class (it's used by three other systems and the original author has long since left the company). You also can't modify the modern interface (the mobile team has frozen it). Your job is to build the **bridge** between them so the app sees clean data while the legacy service keeps doing what it does.

This is the textbook job for the **Adapter pattern**, but you'll write it from scratch — no skipping ahead.

---

## Requirements

Implement the following:

- A class `LegacyWeatherAdapter` that **implements** the `WeatherProvider` interface and **wraps** an instance of `LegacyWeatherStation`.
- All temperatures returned to the modern app must be in **Celsius** (the legacy service emits Fahrenheit).
- All wind speeds returned to the modern app must be in **km/h** (the legacy service emits mph).
- City names from the legacy service may have inconsistent casing (e.g., `"tBILISI"`, `"new york"`). Your adapter must normalize them to title case (e.g., `"Tbilisi"`, `"New York"`).
- If the legacy service throws a `LegacyServiceException`, your adapter must translate it into a `WeatherUnavailableException` (you'll define this) without leaking the legacy exception type to callers.
- Use a Java `record` for the modern `WeatherReading` data type.

---

## Constraints

- Do **not** modify `LegacyWeatherStation` or the `WeatherProvider` interface.
- Conversion math must be exact within `0.01` (use `double`).
- The adapter must be **stateless** — no caching of results inside it (caching is a stretch goal).
- Java 17+. Prefer `record`, `var`, switch expressions, and streams where they help readability.

---

## Examples

```java
// Example 1
LegacyWeatherStation legacy = new LegacyWeatherStation();
WeatherProvider provider = new LegacyWeatherAdapter(legacy);

WeatherReading reading = provider.getCurrentWeather("tbilisi");
// reading.city()        -> "Tbilisi"
// reading.temperatureC() -> 22.22  (was 72°F)
// reading.windKph()      -> 16.09  (was 10 mph)
// reading.condition()    -> "PARTLY_CLOUDY"
```

```java
// Example 2 — legacy service blows up
try {
    provider.getCurrentWeather("atlantis"); // unknown city
} catch (WeatherUnavailableException e) {
    System.out.println(e.getMessage()); // "Could not retrieve weather for atlantis"
    // The original LegacyServiceException must NOT be the visible type.
}
```

---

## Starter code

```java
// === DO NOT MODIFY: legacy code you must adapt ===
public class LegacyWeatherStation {
    /**
     * Returns a CSV string: "CITY_RAW,TEMP_F,WIND_MPH,CONDITION_CODE"
     * Example: "tbilisi,72.0,10.0,PC"
     * Throws LegacyServiceException if the city is unknown.
     */
    public String fetchWeatherCsv(String city) throws LegacyServiceException {
        // ... pretend this calls an old SOAP service
        throw new UnsupportedOperationException("stub for the challenge");
    }
}

public class LegacyServiceException extends Exception {
    public LegacyServiceException(String msg) { super(msg); }
}

// === DO NOT MODIFY: the modern interface your app expects ===
public interface WeatherProvider {
    WeatherReading getCurrentWeather(String city) throws WeatherUnavailableException;
}

// === YOUR JOB STARTS HERE ===
public record WeatherReading(/* TODO: city, temperatureC, windKph, condition */) {}

public class WeatherUnavailableException extends Exception {
    // TODO
}

public class LegacyWeatherAdapter implements WeatherProvider {
    private final LegacyWeatherStation legacy;

    public LegacyWeatherAdapter(LegacyWeatherStation legacy) {
        this.legacy = legacy;
    }

    @Override
    public WeatherReading getCurrentWeather(String city) throws WeatherUnavailableException {
        // TODO:
        // 1. Call legacy.fetchWeatherCsv(city)
        // 2. Parse the CSV
        // 3. Convert F -> C and mph -> km/h
        // 4. Normalize the city name to Title Case
        // 5. Map condition codes (e.g. "PC" -> "PARTLY_CLOUDY", "S" -> "SUNNY", "R" -> "RAINY")
        // 6. Translate any LegacyServiceException into WeatherUnavailableException
        return null;
    }
}
```

---

## Hints

<details>
<summary><strong>Hint 1 (peek)</strong></summary>

The adapter doesn't need to know **how** the legacy service works — only how to translate its outputs. Treat the CSV string as a tiny parsing problem and isolate the conversion math into small private helpers.
</details>

<details>
<summary><strong>Hint 2</strong></summary>

For unit conversions:
- `celsius = (fahrenheit - 32) * 5.0 / 9.0`
- `kph = mph * 1.609344`

For title-casing, splitting on whitespace and mapping each token with a stream is concise. Watch out for empty strings.
</details>

<details>
<summary><strong>Hint 3</strong></summary>

A `switch` expression is a clean way to map condition codes:

```java
String condition = switch (code) {
    case "S"  -> "SUNNY";
    case "PC" -> "PARTLY_CLOUDY";
    case "R"  -> "RAINY";
    default   -> "UNKNOWN";
};
```

For the exception translation, catch `LegacyServiceException` and rethrow `new WeatherUnavailableException(...)` — set the original as the cause, but never expose the type in your public signature.
</details>

---

## Bonus / stretch goals

1. **Caching decorator.** Build a `CachingWeatherProvider` that **decorates** any `WeatherProvider` and caches results for 60 seconds per city. This combines Adapter with the Decorator pattern — exactly how layered providers are built in real codebases.
2. **Bulk fetch.** Add a default method `Map<String, WeatherReading> getAll(List<String> cities)` to `WeatherProvider` and override it in your adapter using parallel streams. Be careful about exception handling — what should happen if one city fails?

---

## Self-check

Before you call it done, you should be able to answer:

1. Why is the Adapter pattern the right choice here, instead of just rewriting `LegacyWeatherStation`?
2. What's the time complexity of `getCurrentWeather` in your adapter? Is the CSV parsing dominating, or is it constant-time?
3. How does your adapter behave if the legacy service returns a malformed CSV (e.g., missing a column)? Does it crash, or fail gracefully?
4. If you added the caching decorator, where does the cache live, and what happens to thread-safety under concurrent reads?
5. Could you swap `LegacyWeatherStation` for a totally different provider (say, a REST client) without changing the mobile app? What would change in your design?

---

*Want the reference solution or feedback on your implementation? Just ask in chat.*
