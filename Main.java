package edu.sdccd.cisc191;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city name:");
        String city = scanner.nextLine();

        WeatherApiClient apiClient = new WeatherApiClient();
        WeatherParser parser = new WeatherParser();
        WeatherDisplay display = new WeatherDisplay();

        try {
            String weatherData = apiClient.getWeatherData(city);
            WeatherRecord weather = parser.parseWeatherData(weatherData);
            display.displayWeather(weather);
        } catch (IOException e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }
    }
}