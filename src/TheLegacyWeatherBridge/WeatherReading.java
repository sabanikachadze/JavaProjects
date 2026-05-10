package TheLegacyWeatherBridge;

public record WeatherReading(String city, double temperatureC, double windKph, String condition) {

    @Override
    public String toString() {
        return String.format("%-15s | %5.2f °C | %5.2f km/h | %s",
            city, temperatureC, windKph, condition);
    }
}
