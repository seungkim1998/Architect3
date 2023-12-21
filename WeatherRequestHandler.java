package edu.sdccd.cisc191;

import java.net.Socket;

public abstract class WeatherRequestHandler implements Runnable {

    public WeatherRequestHandler(Socket clientSocket, WeatherService weatherService) {
    }
}
