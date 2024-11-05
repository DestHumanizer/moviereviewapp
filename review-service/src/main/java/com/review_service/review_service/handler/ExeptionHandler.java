package com.review_service.review_service.handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.review_service.review_service.dto.ErrorResponse;
import com.review_service.review_service.exceptions.ReviewNotFoundException;
import com.review_service.review_service.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ExeptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException e) {
		String errors = e.getBindingResult()
				.getAllErrors()
				.stream()
				.map(error -> ((FieldError) error).getField() + ": " + 
				error.getDefaultMessage())
				.toList().toString();
		return new ErrorResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), errors);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNotificationsFoundException(UserNotFoundException ex) {
		return new ErrorResponse(ex.getCode(), ex.getMessage());
	}
	
	@ExceptionHandler(ReviewNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNotificationsFoundException(ReviewNotFoundException ex) {
		return new ErrorResponse(ex.getCode(), ex.getMessage());
	}

}
