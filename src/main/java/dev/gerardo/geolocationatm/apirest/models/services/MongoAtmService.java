package dev.gerardo.geolocationatm.apirest.models.services;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import dev.gerardo.geolocationatm.apirest.models.repositories.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoAtmService implements AtmService {

    @Autowired
    private AtmRepository repository;

    @Override
    public Optional<List<Atm>> findAtmsByCoordinates(Long latitude, Long longitude) {
        List<Atm> result = repository.findAtmsByCoordinates(latitude, longitude);

        if (!result.isEmpty()) {
            return Optional.of(result);
        }

        return Optional.empty();
    }
}
