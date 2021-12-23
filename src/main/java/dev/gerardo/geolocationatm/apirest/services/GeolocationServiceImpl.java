package dev.gerardo.geolocationatm.apirest.services;

import dev.gerardo.geolocationatm.apirest.models.dto.Point;
import org.springframework.stereotype.Service;

@Service
public class GeolocationServiceImpl implements GeolocationService {

    private Double radius = 6370.00;

    @Override
    public Double calculateDistance(Point a, Point b) {
        Double latitude = Math.toRadians(a.getLatitude() - b.getLatitude());
        Double longitude = Math.toRadians(a.getLongitude() - b.getLongitude());

        Double sinLatitude = Math.sin(latitude / 2) * Math.sin(latitude / 2);
        Double sinLongitude = Math.sin(longitude / 2) * Math.sin(longitude / 2);
        Double angle = sinLatitude + Math.cos(Math.toRadians(a.getLatitude())) * Math.cos(Math.toRadians(b.getLatitude())) * sinLongitude;
        Double c = 2 * Math.atan2(Math.sqrt(angle), Math.sqrt(1 - angle));
        return c * radius;
    }
}
