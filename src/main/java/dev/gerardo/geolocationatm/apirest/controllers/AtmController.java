package dev.gerardo.geolocationatm.apirest.controllers;

import dev.gerardo.geolocationatm.apirest.exceptions.NotFoundException;
import dev.gerardo.geolocationatm.apirest.mappers.AtmMapper;
import dev.gerardo.geolocationatm.apirest.models.dto.AtmDTO;
import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import dev.gerardo.geolocationatm.apirest.services.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atms")
public class AtmController {

    @Autowired
    private AtmService service;

    /**
     * Endpoint que regresa una lista de los atm más cercanos a tu ubicación.
     * @param latitude latitud de tu posición actual.
     * @param longitude longitud de tu posición actual.
     * @return un ohjeto de tipo ResponseEntity con la lista de Atms cercanos.
     */
    @GetMapping("/filter")
    public ResponseEntity<List<AtmDTO>> findAtmsByCoordinates(
            @RequestParam(name = "latitude", required = true) Long latitude,
            @RequestParam(name = "longitude", required = true) Long longitude
    ) {
        Optional<List<Atm>> result = service.findAtmsByCoordinates(latitude, longitude);

        if (!result.isPresent()) {
            throw new NotFoundException("No hay atms cercanos a tu ubicación");
        }

        List<AtmDTO> dtos = result.get().stream().map(AtmMapper::mapAtm).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    /**
     * Endpoint para ver toda la lista de atms en el sistema.
     * @return ResponseEntity con la información de los atms del sistema.
     * @throws NotFoundException si no hay atm alguno en el sistema.
     */
    @GetMapping
    public ResponseEntity<List<AtmDTO>> findAllAtms() {
        Optional<List<Atm>> result = service.findAllAtms();
    
        if (!result.isPresent()) {
            throw new NotFoundException("No hay atms en la base de datos");
        }

        List<AtmDTO> dtos = result.get().stream().map(AtmMapper::mapAtm).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

}
