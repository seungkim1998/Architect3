package edu.sdccd.cisc191;

public class WeatherParser {

    @FunctionalInterface
    interface JsonParser {
        WeatherRecord parse(String json);
    }

    public WeatherRecord parseWeatherData(String jsonResponse) {
        JsonParser parser = json -> new Gson().fromJson(json, WeatherRecord.class);
        return parser.parse(jsonResponse);
    }

    private class Gson {
        public WeatherRecord fromJson(String json, Class<WeatherRecord> weatherRecordClass) {
            return null;
        }
    }
}