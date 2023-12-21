package edu.sdccd.cisc191;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class WeatherApiClient {
    private static final String API_KEY = "35e35282ddd4854b481b88b2b9a1205c ";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public String getWeatherData(String city) throws IOException {
        String url = String.format("%s?q=%s&appid=%s&units=metric", BASE_URL, city, API_KEY);
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            return EntityUtils.toString(httpClient.execute(request).getEntity());
        }
    }
}