package edu.sdccd.cisc191;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WeatherRecord {
    @Id
    private String city;
    private double temperature;
    private String description;
    public WeatherRecord() {
    }
    public static void main(String[] args) {
    }
    public WeatherRecord(String city, double temperature, String description){
        this.city = city;
        this.temperature = temperature;
        this.description = description;
    }

    public String getCity() {
        return city;
    }
    public double getTemperature() {
        return temperature;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "WeatherRecord{" +
                "city ='" + city + '\'' +
                ", temperature=" + temperature +
                ", description=" + description +
                '}';
    }
}
