package com.example.nada.exceptions;

import com.example.nada.services.exceptions.EntitiesNotFoundException;
import com.example.nada.services.exceptions.IntegityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobaExceptionHandler {

    @ExceptionHandler(value = EntitiesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<StandardError> entitiesError(EntitiesNotFoundException e){
        HttpStatus status=HttpStatus.NOT_FOUND;
        StandardError error= new StandardError();
        error.setStatus(status.value());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(value= IntegityException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<StandardError> integrityError(IntegityException e){
        HttpStatus status=HttpStatus.NOT_FOUND;
        StandardError error= new StandardError();
        error.setStatus(status.value());
        error.setMessage(e.getMessage());
        return ResponseEntity.status(status).body(error);
    }
}
