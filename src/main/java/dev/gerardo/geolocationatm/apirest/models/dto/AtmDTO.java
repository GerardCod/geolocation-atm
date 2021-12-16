package dev.gerardo.geolocationatm.apirest.models.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AtmDTO {
    private Long id;
    private String city;
    private String state;
    private String address;
    private String street;
}
