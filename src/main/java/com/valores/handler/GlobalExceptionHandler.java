package com.valores.handler;

import com.valores.entity.ErrorPersonalizado;
import com.valores.exception.AlreadyExistsException;
import com.valores.exception.NotFoundException;
import com.valores.exception.NullPointerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ErrorPersonalizado handler(NotFoundException ex){
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(com.valores.exception.NullPointerException.class)
    public ErrorPersonalizado handler(NullPointerException ex){
        return new ErrorPersonalizado(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    @ExceptionHandler(AlreadyExistsException.class)
    public ErrorPersonalizado handler(AlreadyExistsException ex){
        return new ErrorPersonalizado(ex.getMessage());
    }

}
