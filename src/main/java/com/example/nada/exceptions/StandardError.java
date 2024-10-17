package com.example.nada.exceptions;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StandardError {
    private Integer status;
    private String message;

    public StandardError(String sms){
        super();
        this.message=sms;
    }

}
