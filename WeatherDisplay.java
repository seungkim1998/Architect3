package edu.sdccd.cisc191;

public class WeatherDisplay {

    public void displayWeather(WeatherRecord weather) {
        if (weather != null) {
            System.out.println("Weather for " + weather.getCity() + ":");
            System.out.println("Temperature: " + weather.getTemperature() + "°C");
            System.out.println("Description: " + weather.getDescription());
        } else {
            System.out.println("Weather data is not available.");
        }
    }
}