package com.example.nada.services.exceptions;

public class EntitiesNotFoundException extends RuntimeException{

    public EntitiesNotFoundException(String sms){
        super(sms);
    }
}
