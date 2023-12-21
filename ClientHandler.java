package edu.sdccd.cisc191;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            // Handle the client request
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // Process the client request (add your logic here)
                String response = "Server response: " + clientMessage.toUpperCase();

                // Send the response back to the client
                writer.println(response);
            }
        } catch (IOException e) {
            // Handle exceptions (e.g., IOException) according to your needs
            e.printStackTrace();
        } finally {
            try {
                // Close the client socket when the thread is done
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}