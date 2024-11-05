package com.user_service.user_service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.user_service.user_service.dto.ErrorResponse;
import com.user_service.user_service.exception.ConflictException;
import com.user_service.user_service.exception.UserNotFoundException;

@ControllerAdvice
public class ExeptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		String errors = ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
				.toList().toString();
		
		return new ErrorResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), errors);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNotificationsFoundException(
			UserNotFoundException ex) {
		return new ErrorResponse(ex.getCode(), ex.getMessage());
	}
	
	@ExceptionHandler(ConflictException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse habndleConflictException(ConflictException ex) {
		return new ErrorResponse(ex.getCode(), ex.getMessage());
		
	}

}
