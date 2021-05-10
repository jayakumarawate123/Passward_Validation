/*
 * 
 * Test cases for validating the password validation functionality
 * 
 *  @author Jayakumar
 *  
 */

package com.password.validation.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.password.validation.constant.ErrorConstantMessage;
import com.password.validation.exception.PasswordValidationException;
import com.password.validation.service.PasswordValidationService;

@DisplayName("A test class for validating the password")
class PasswordValidationServiceImpleTest {

	private PasswordValidationService passwordValidation;

	@BeforeEach
	public void steup() {
		passwordValidation = new PasswordValidationServiceImpl();
	}

	@DisplayName("Validating password should not null")
	@Test
	void validatePassword_ThrowsPasswordValidationException_IfPasswordIsNull() {
		PasswordValidationException pwdExcp = Assertions.assertThrows(PasswordValidationException.class, () -> {
			passwordValidation.validatePassword(null);
		});
		assertEquals(ErrorConstantMessage.PASSWORD_SHOULD_NOT_NULL, pwdExcp.getMessage());
	}


}
