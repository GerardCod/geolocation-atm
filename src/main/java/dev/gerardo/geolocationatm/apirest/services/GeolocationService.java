package dev.gerardo.geolocationatm.apirest.services;

import dev.gerardo.geolocationatm.apirest.models.dto.Point;

public interface GeolocationService {

    Double calculateDistance(Point a, Point b);

}
