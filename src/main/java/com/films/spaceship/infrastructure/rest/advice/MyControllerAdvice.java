package com.films.spaceship.infrastructure.rest.advice;


import com.films.spaceship.infrastructure.adapters.exceptions.SpaceshipException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(SpaceshipException.class)
    public ResponseEntity<String> handleEmptyInput(SpaceshipException emptyInputException){
        return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
    }

}
