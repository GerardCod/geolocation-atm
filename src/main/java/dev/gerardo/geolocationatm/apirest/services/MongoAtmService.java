package dev.gerardo.geolocationatm.apirest.services;

import dev.gerardo.geolocationatm.apirest.models.dto.Point;
import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import dev.gerardo.geolocationatm.apirest.repositories.AtmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MongoAtmService implements AtmService {

    @Autowired
    private AtmRepository repository;

    @Autowired
    private GeolocationService service;

    @Override
    public Optional<List<Atm>> findAtmsByCoordinates(Double latitude, Double longitude) {
        List<Atm> result = repository.findAtmsByType("ATM");
        Point user = new Point(latitude, longitude);
        List<Atm> resultFilter = result.stream()
                .filter(p -> service.calculateDistance(user, Point.fromAtm(p)) < 10)
                .collect(Collectors.toList());

        if (!resultFilter.isEmpty()) {
            return Optional.of(resultFilter);
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

	@Override
	public Optional<List<Atm>> findAtmsByZipCodeAndState(String zipCode, String state) {
		List<Atm> result = repository.findAtmsByZipCodeAndState(zipCode, state);
		
		if (!result.isEmpty()) {
			return Optional.of(result);
		}
		
		return Optional.empty();
	}

    @Override
    public Optional<List<Atm>> findAtmsByInput(Double latitude, Double longitude, String zipCode, String state) {
        List<Atm> result = repository.findAtmsByZipCodeAndState(zipCode, state);
        System.out.println(result.size());
        Point user = new Point(latitude, longitude);
        List<Atm> resultFilter = result.stream().filter(atm -> service.calculateDistance(user, Point.fromAtm(atm)) < 10).collect(Collectors.toList());

        return Optional.of(resultFilter);
    }
}
