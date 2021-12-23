package dev.gerardo.geolocationatm.apirest.mappers;

import dev.gerardo.geolocationatm.apirest.models.dto.AtmDTO;
import dev.gerardo.geolocationatm.apirest.models.entities.Atm;

public class AtmMapper {

    public static AtmDTO mapAtm(Atm atm) {
        AtmDTO dto = new AtmDTO();
        dto.setId(atm.getAtmId());
        dto.setCity(atm.getCity());
        dto.setState(atm.getState());
        dto.setAddress(atm.getAddress());
        dto.setStreet(atm.getStreet());
        dto.setType(atm.getType());
        return dto;
    }

}
