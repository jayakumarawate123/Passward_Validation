/*
 * Custom exception handler 
 * 
 * @author Jayakumar
 * 
 */

package com.password.validation.exception;

public class PasswordValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for populating the error message
	 * 
	 * @param s
	 */
	public PasswordValidationException(String errorMsg) {
		super(errorMsg);
	}

	/**
	 * Constructor for populating the exception
	 * 
	 * @param e
	 */
	public PasswordValidationException(Exception e) {
		super(e);
	}

	/**
	 * Constructor for populating the error message and exception
	 * 
	 * @param s
	 * @param e
	 */
	public PasswordValidationException(String errorMsg, Exception e) {
		super(errorMsg, e);
	}

}
