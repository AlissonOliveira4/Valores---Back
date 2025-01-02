package com.valores.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorPersonalizado {

    private String message;

    public ErrorPersonalizado(String message){
        this.message = message;
    }

}
