package edu.sdccd.cisc191;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeatherServer {

    private final int port;
    private final WeatherService weatherService;
    private final ExecutorService threadPool;

    public WeatherServer(int port, WeatherService weatherService) {
        this.port = port;
        this.weatherService = weatherService;
        this.threadPool = Executors.newFixedThreadPool(10); // Example: 10 threads
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Weather Server is running on port " + port);

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    threadPool.submit(new WeatherRequestHandler(clientSocket, weatherService) {
                        @Override
                        public void run() {

                        }
                    });
                } catch (IOException e) {
                    System.err.println("Error accepting client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        WeatherService weatherService = new WeatherServiceBuilder().setWeatherApiClient(new WeatherApiClient()).setWeatherParser(new WeatherParser()).createWeatherService();
        WeatherServer server = new WeatherServer(8080, weatherService);
        server.start();
    }
}