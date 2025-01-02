package com.valores.handler;

import com.valores.entity.ErrorPersonalizado;
import com.valores.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ErrorPersonalizado handler(NotFoundException ex){
        return new ErrorPersonalizado(ex.getMessage());
    }

}
