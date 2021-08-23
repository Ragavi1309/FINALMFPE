package com.cts.pointsmicroservice.exception;

//thrown in case of invalid credentials
public class InvalidUserException extends RuntimeException{
	
	/**
	 * thrown when a user with invalid credentials 
	 * logged in 
	 * 
	 * @return message
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserException(String msg) {
		super(msg);
		
	}

}
