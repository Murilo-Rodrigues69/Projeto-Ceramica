package com.ceramicamaster.gerenciador2.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(GerenciadorExceptionResolver.class)
    public ResponseEntity<StandardError> handleGerenciadorException(GerenciadorExceptionResolver e, HttpServletRequest request) {
        StandardError err = new StandardError(
            Instant.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Erro de Negócio",
            e.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
