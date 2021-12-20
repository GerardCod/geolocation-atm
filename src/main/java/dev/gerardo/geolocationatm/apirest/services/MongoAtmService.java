package dev.gerardo.geolocationatm.apirest.services;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import dev.gerardo.geolocationatm.apirest.repositories.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MongoAtmService implements AtmService {

    @Autowired
    private AtmRepository repository;

    @Override
    public Optional<List<Atm>> findAtmsByCoordinates(Long latitude, Long longitude) {
        List<Atm> result = repository.findAtmsByLatitudeAndLongitude(latitude, longitude);

        if (!result.isEmpty()) {
            return Optional.of(result);
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<Atm>> findAllAtms() {
        Page<Atm> resultPage = repository.findAll(Pageable.ofSize(10));
        
        if (resultPage.hasContent()) {
        	
            return Optional.of(resultPage.getContent());
        }
        
        return Optional.empty();
    }
}
