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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	
	@DisplayName("Validating password should have atleast one lowercase letter")
	@ParameterizedTest
	@ValueSource(strings = { "PASSWORDS", "#4AF", "", "   ", "#%$^&", "#%$^&@#$%","6454ADGBHY" })
	void validatePassword_ThrowsPasswordValidationException_IfPasswordNotHaveAtleastSingleLowercaseLetter(String password) {

		PasswordValidationException pwdExcp = Assertions.assertThrows(PasswordValidationException.class, () -> {
			passwordValidation.validatePassword(password);
		});
		assertEquals(ErrorConstantMessage.PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_LOWERCASE_LETTER, pwdExcp.getMessage());
	}
	
	@DisplayName("Validating password length is not greater than 8 or not have atleast single"
			+ "	 * Upper / on number")
	@ParameterizedTest
	@ValueSource(strings = { "password", "pass##", "@a","a","&%$aa*&","  a  ","null" })
	void validatePassword_ThrowsPasswordValidationException_IfPasswordLengthIsNotGreaterThanEightOrNotHaveAtleastOneUpperOrOneNumber(
			String password) {

		PasswordValidationException pwdExcp = Assertions.assertThrows(PasswordValidationException.class, () -> {
			passwordValidation.validatePassword(password);
		});
		assertEquals(
				ErrorConstantMessage.PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_UPPERCASE_CHAR_OR_ONE_NUMBER_OR_ATLEAST_EIGHT_CHAR,
				pwdExcp.getMessage());
	}
	
	
	@DisplayName("Password have atleast one lowercase letter and length is greater than 8 expected success")
	@ParameterizedTest
	@ValueSource(strings = { "pass@#$%*&", "    p    ","pA","passWords","a1&*^%","k  M" })
	void validatePassword_ValidPassword_PasswordHaveAtleastOneLowercaseLetterAndLenghtGreaterThanEight(String password)
			throws PasswordValidationException {
		assertEquals(ErrorConstantMessage.SUCCESS, passwordValidation.validatePassword(password));
	}
}
