/*
 * Validate the password
 * 
 * Password should not null 
 * Password should have atleast single lower char
 * Password should have atleast single lower char and atleast one Upper char or atleast one lower char or length grater than 8  
 * 
 * @author Jayakumar
 * 
 */
package com.password.validation.service;

import com.password.validation.exception.PasswordValidationException;

public interface PasswordValidationService {

	/**
	 * Method for validating the password
	 * 
	 * @param password
	 * @return
	 * @throws PasswordValidationException
	 */
	public String validatePassword(final String password);
}
