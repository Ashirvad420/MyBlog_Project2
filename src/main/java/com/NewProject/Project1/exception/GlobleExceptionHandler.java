package com.NewProject.Project1.exception;

import com.NewProject.Project1.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobleExceptionHandler extends ResponseEntityExceptionHandler {

    // How to handle the Exception and return a proper message

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
       ResourceNotFoundException e,
       WebRequest webRequest

    )
    {
    ErrorDetails errorDetails = new ErrorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

/*
    why ResponseEntity?
    -> because it send the response back to the post man
 */
