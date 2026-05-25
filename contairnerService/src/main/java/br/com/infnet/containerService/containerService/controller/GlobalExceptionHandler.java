package br.com.infnet.containerService.containerService.controller;

import br.com.infnet.containerService.containerService.dto.ErrorResponse;
import br.com.infnet.containerService.containerService.exception.TerminalValidationException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleContainerNotFound(EntityNotFoundException ex){
        ErrorResponse response = new ErrorResponse("CONTAINER_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(TerminalValidationException.class)
    public ResponseEntity<ErrorResponse> handleTErminalValidationException(
            TerminalValidationException ex,
            HttpServletRequest request
    ){
        ErrorResponse terminalInvalido = new ErrorResponse("TERMINAL_INVALIDO", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(terminalInvalido);
    }

}
