package com.mouritech.feigndemo.feignclientexample.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	
	
	public ResponseEntity<?> handleException(ProductNotFoundException exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(exception.getMessage());
		
	}

}