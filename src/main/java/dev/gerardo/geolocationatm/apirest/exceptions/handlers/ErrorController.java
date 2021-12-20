package dev.gerardo.geolocationatm.apirest.exceptions.handlers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.gerardo.geolocationatm.apirest.exceptions.NotFoundException;

@RestControllerAdvice
public class ErrorController {
  
  @ExceptionHandler(value = NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String, String> notFoundHandler(NotFoundException ex) {
    
	Map<String, String> response = new HashMap<>();
    response.put("message", ex.getMessage());
    response.put("detailedError", Arrays.toString(ex.getStackTrace()));
    
    return response;
  }

}
