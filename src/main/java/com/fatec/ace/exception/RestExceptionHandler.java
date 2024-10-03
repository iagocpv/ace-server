package com.fatec.ace.exception;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ConfigurationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

import jakarta.persistence.EntityExistsException;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResource> illegalArgumentException(IllegalArgumentException e) {
		final HttpStatus status = HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), "Argumento inválido"));
	}
	
	@ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResource> noSuchElementException(NoSuchElementException e) {
		final HttpStatus status = HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), "Elemento não encontrado"));
	}
	
	@ExceptionHandler(ConfigurationException.class)
    public ResponseEntity<ExceptionResource> configurationException(ConfigurationException e) {
		final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), "Erro de configuração"));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResource> constraintViolationException(ConstraintViolationException e) {
		final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), "Violação de restrição"));
	}
	
	@ExceptionHandler(InvalidDefinitionException.class)
    public ResponseEntity<ExceptionResource> invalidDefinitionException(InvalidDefinitionException e) {
		final HttpStatus status = HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), e.getMessage().split("\n")[0]));
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ExceptionResource> emptyResultDataAccessException(EmptyResultDataAccessException e) {
		final HttpStatus status = HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), "Elemento não encontrado"));
	}
	
	@ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ExceptionResource> entityExistsException(EntityExistsException e) {
		final HttpStatus status = HttpStatus.CONFLICT;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionResource> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		final HttpStatus status = HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), "Falha na validação: " + e.getBindingResult().getFieldError().getDefaultMessage() ));
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ExceptionResource> SQLException(SQLException e) {
		final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity.status(status)
				.body(new ExceptionResource(status.value(), e.getMessage()));
	}

}
