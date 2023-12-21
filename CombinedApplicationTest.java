package edu.sdccd.cisc191;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CombinedApplicationTest {

    @Autowired
    private WeatherRecordRepository repository;

    //Test for Module 12: Database
    @Test
    public void testSaveAndFindWeatherRecord() {
        WeatherRecord record = new WeatherRecord("TestCity", 25.0, "Sunny");
        repository.save(record);

        WeatherRecord found = repository.findByCity("TestCity").get(0);
        assertNotNull(found);
        assertEquals("TestCity", found.getCity());
        assertEquals(25.0, found.getTemperature());
        assertEquals("Sunny", found.getDescription());
    }

    private void asserNotNull(WeatherRecord found) {

    }

    //Test for Module 13: Concurrency
    @Test
    public void testMultipleClientConnectins() {
        new Thread(() -> {
            WeatherServer server = new WeatherServer(8080, new WeatherService());
            server.start();
        }).start();

        try {
            Socket client1 = new Socket("Localhost", 8080);
            Socket client2 = new Socket("Localhost", 8080);

            assertTrue(client1.isConnected());
            assertTrue(client2.isConnected());

            client1.close();
            client2.close();
        } catch (UnknownHostException e) {
            fail("Unknown Host Exception");
        } catch (IOException e) {
            fail("IOException occurred");
        }
    }
}
