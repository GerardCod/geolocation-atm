package dev.gerardo.geolocationatm.apirest.models.repositories;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends MongoRepository<Atm, String> {

    List<Atm> findAtmsByCoordinates(Long latitude, Long longitude);

}
