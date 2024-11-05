package com.review_service.review_service.exceptions;

import lombok.Getter;

@Getter
public class ReviewNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	public ReviewNotFoundException(String code, String message) {
		super(message);
		
		this.code = code;
	}

}
