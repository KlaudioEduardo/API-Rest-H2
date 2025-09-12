package com.klaudiodev.livraria.controller.exception;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
	
	private Instant timestamp;
	
	private Integer status;
	
	private String error;
	
	private String message;
	
	private String path;

}
