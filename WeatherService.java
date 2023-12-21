package edu.sdccd.cisc191;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class WeatherService {

    @Autowired
    private WeatherRecordRepository weatherRecordRepository;
    private final WeatherApiClient weatherApiClient;
    private final WeatherParser weatherParser;


    private WeatherService(WeatherApiClient weatherApiClient, WeatherParser weatherParser) {
        this.weatherApiClient = weatherApiClient;
        this.weatherParser = weatherParser;
    }

    public static WeatherService createWeatherService(WeatherApiClient weatherApiClient, WeatherParser weatherParser) {
        return new WeatherService(weatherApiClient, weatherParser);
    }

    public WeatherRecord getWeatherForCity(String city) {
        try {
            String jsonResponse = weatherApiClient.getWeatherData(city);
            WeatherRecord weatherRecord = weatherParser.parseWeatherData(jsonResponse);
            return weatherRecord;
        } catch (IOException e) {
            // Handle exceptions (e.g., network issues, API errors)
            System.err.println("Error fetching weather data: " + e.getMessage());
            return null;
        }
    }

    public void saveWeatherRecord(WeatherRecord weatherRecord) {
        if (weatherRecord != null) {
            weatherRecordRepository.save(weatherRecord);
        }
    }

    public WeatherRecord getWeatherData(String city) {
        return null;
    }
}
