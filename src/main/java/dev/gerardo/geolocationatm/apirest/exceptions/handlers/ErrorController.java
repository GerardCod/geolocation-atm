package dev.gerardo.geolocationatm.apirest.exceptions.handlers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.gerardo.geolocationatm.apirest.exceptions.NotFoundException;

@ControllerAdvice
public class ErrorController {
  
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Map<String, String>> notFoundHandler(NotFoundException ex) {
    Map<String, String> response = new HashMap<>();
    response.put("message", ex.getMessage());
    response.put("detailedError", Arrays.toString(ex.getStackTrace()));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

}
