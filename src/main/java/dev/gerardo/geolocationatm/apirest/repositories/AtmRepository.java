package dev.gerardo.geolocationatm.apirest.repositories;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtmRepository extends MongoRepository<Atm, String> {

    @Query("{'address': { $regex: ?0 }, 'state': ?1, 'type': 'ATM'}")
    List<Atm> findAtmsByZipCodeAndState(String zipCode, String state);

    List<Atm> findAtmsByState(String state);

    List<Atm> findAtmsByType(String type);
}
