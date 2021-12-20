package dev.gerardo.geolocationatm.apirest.services;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;

import java.util.List;
import java.util.Optional;

public interface AtmService {

    Optional<List<Atm>> findAtmsByCoordinates(Long latitude, Long longitude);

}
