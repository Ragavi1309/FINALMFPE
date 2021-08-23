package com.cts.pointsmicroservice.exception;

//thrown when an error occurs in a different microService
public class MicroserviceException extends Exception {

	/**
	 * thrown when an error occur in a microService 
	 */
	private static final long serialVersionUID = 1L;

	public MicroserviceException(String message){
		super(message);
	}
}
