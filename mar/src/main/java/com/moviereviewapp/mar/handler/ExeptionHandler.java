package com.moviereviewapp.mar.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.moviereviewapp.mar.dto.ErrorResponse;
import com.moviereviewapp.mar.exceptions.ConflictException;

@RestControllerAdvice
public class ExeptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException e) {
		String errors = e.getBindingResult()
				.getAllErrors()
				.stream()
				.map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
				.toList().toString();
		return new ErrorResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), errors);
	}
	
	public ErrorResponse handleConflictException(ConflictException e) {
		return new ErrorResponse(e.getCode(), e.getMessage());
	}
	
	

}
