package com.klaudiodev.livraria.controller.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.klaudiodev.livraria.service.exception.EntityNotFound;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<ErrorResponse> notFound(EntityNotFound e, HttpServletRequest request) {
		String error = "Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErrorResponse err = new ErrorResponse(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
