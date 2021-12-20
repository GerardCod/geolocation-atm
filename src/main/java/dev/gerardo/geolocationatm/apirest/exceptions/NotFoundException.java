package dev.gerardo.geolocationatm.apirest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4827754139319608798L;

	public NotFoundException(String message) {
        super(message);
    }

}
