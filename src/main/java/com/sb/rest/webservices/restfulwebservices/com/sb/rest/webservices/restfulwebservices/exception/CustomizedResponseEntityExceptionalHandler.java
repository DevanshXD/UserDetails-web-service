package com.sb.rest.webservices.restfulwebservices.com.sb.rest.webservices.restfulwebservices.exception;

import com.sb.rest.webservices.restfulwebservices.com.sb.rest.webservices.restfulwebservices.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizedResponseEntityExceptionalHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails errordetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails errordetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.NOT_FOUND);

    }

}
