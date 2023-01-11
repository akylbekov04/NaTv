package com.example.finalproject.exceptions;

import com.example.finalproject.models.response.ResponseExceptions;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<?> handleCreateEntityException(NotFoundException exception) {
        return new ResponseEntity(ResponseExceptions.getErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
