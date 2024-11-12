package com.example.workshopmongo.resources.exception;


import com.example.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError("Não encontrado", e.getMessage(), request.getRequestURI(), status.value(), System.currentTimeMillis());
        return ResponseEntity.status(status).body(err);
    }

}
