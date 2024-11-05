package com.moviereviewapp.mar.exceptions;

import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	
	public ConflictException(String code, String message) {
		super(message);
		this.code = code;
	}

}
