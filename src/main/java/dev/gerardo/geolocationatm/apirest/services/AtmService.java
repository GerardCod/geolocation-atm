package dev.gerardo.geolocationatm.apirest.services;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;

import java.util.List;
import java.util.Optional;

public interface AtmService {

    Optional<List<Atm>> findAtmsByCoordinates(Double latitude, Double longitude, String state);

    Optional<List<Atm>> findAllAtms();
    
    Optional<List<Atm>> findAtmsByZipCodeAndState(String zipCode, String state);
}
