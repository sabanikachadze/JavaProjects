package TheLegacyWeatherBridge;

public interface WeatherProvider {
    WeatherReading getCurrentWeather(String city) throws WeatherUnavailableException;
}