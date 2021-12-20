package dev.gerardo.geolocationatm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GeolocationatmApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeolocationatmApplication.class, args);
    }

}
