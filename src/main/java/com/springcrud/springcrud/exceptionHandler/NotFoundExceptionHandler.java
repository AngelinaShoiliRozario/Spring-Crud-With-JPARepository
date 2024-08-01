package com.springcrud.springcrud.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springcrud.springcrud.exception.NotFoundException;
import com.springcrud.springcrud.model.NotFoundEntity;


@ControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> notFoundExceptionHandler(NotFoundException exc){
        NotFoundEntity notFoundEntity = new NotFoundEntity(exc.getMessage(),404,new Date().getTime());
        return new ResponseEntity<>(notFoundEntity, HttpStatus.NOT_FOUND);
    }
}
