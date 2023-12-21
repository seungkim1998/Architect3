package edu.sdccd.cisc191;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WeatherRecordRepository extends CrudRepository<WeatherRecord, Long> {

    List<WeatherRecord> findByCity(String city);

}

