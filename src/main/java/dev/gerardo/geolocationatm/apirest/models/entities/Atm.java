package dev.gerardo.geolocationatm.apirest.models.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("atms")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Atm {

    @Id
    private String id;

    private Long atmId;
    private String street;
    private String city;
    private String address;
    private String state;
    private Double latitude;
    private Double longitude;
    private String type;
}
