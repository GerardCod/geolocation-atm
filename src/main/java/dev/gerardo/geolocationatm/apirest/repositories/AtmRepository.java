package dev.gerardo.geolocationatm.apirest.repositories;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends MongoRepository<Atm, String> {

    List<Atm> findAtmsByLatitudeAndLongitude(Long latitude, Long longitude);

}
