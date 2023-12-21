package edu.sdccd.cisc191;

public class WeatherServiceBuilder {
    private WeatherApiClient weatherApiClient;
    private WeatherParser weatherParser;

    public WeatherServiceBuilder setWeatherApiClient(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
        return this;
    }

    public WeatherServiceBuilder setWeatherParser(WeatherParser weatherParser) {
        this.weatherParser = weatherParser;
        return this;
    }

    public WeatherService createWeatherService() {
        return WeatherService.createWeatherService(weatherApiClient, weatherParser);
    }
}