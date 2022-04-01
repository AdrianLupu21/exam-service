package com.exam.examservice.controller.aop;

import com.exam.examservice.controller.aop.ErrorDTO;
import com.exam.examservice.controller.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEntityNotFoundException(ResourceNotFoundException entityNotFoundException,
                                                                  WebRequest webRequest){
        String description = webRequest.getDescription(false);
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), entityNotFoundException.getMessage(),
                new Date(), description);
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
