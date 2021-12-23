package dev.gerardo.geolocationatm.apirest.models.dto;

import dev.gerardo.geolocationatm.apirest.models.entities.Atm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private Double latitude;
    private Double longitude;

    public static Point fromAtm(Atm atm) {
        return new Point(atm.getLatitude(), atm.getLongitude());
    }
}
