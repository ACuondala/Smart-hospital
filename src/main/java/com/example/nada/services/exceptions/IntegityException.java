package com.example.nada.services.exceptions;

public class IntegityException extends RuntimeException{

    public IntegityException(String sms){
        super(sms);
    }
}
