package TheLegacyWeatherBridge;

import java.util.Map;

public class LegacyWeatherStation {

    private static final Map<String, String> FAKE_DB = Map.of(
        "tbilisi",   "tBILISI,72.0,10.0,PC",
        "new york",  "new york,68.0,12.0,S",
        "london",    "LONDON,55.0,8.0,R",
        "tokyo",     "tokyo,77.0,5.0,S",
        "berlin",    "Berlin,60.0,15.0,PC"
    );

    public String fetchWeatherCsv(String city) throws LegacyServiceException {
        if (city == null) {
            throw new LegacyServiceException("city must not be null");
        }

        String key = city.toLowerCase();
        String csv = FAKE_DB.get(key);

        if (csv == null) {
            throw new LegacyServiceException(
                "Unknown city in legacy weather DB: " + city
            );
        }

        return csv;
    }

}