/*
 * 
 * Test cases for validating the util
 * 
 *  @author Jayakumar
 *  
 */

package com.password.validation.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("A test class for validation util class methods")
class ValidationUtilTest {

	@DisplayName("Expecting true if value is null else false")
	@Test
	void isNull_True_ifValueNull() {
		assertTrue(ValidationUtil.isNull.test(null));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "password","a","#$%C"})
	void isPasswordLengthLessThanEight_True_ifValueIsSingleWhiteSpace(String str) {
		assertTrue(ValidationUtil.isPasswordLengthLessThanEight.test(str));
	}

	@DisplayName("Expecting False if password not have at least one upper letter")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "password","a","#$%"})
	void isPasswordHaveAtLeastSingleUpperChar_False_IfValueNotHaveAtleastOneUpperLetter(String str) {
		assertFalse(ValidationUtil.isPasswordHaveAtLeastSingleUpperChar.test(str));
	}

	@DisplayName("Expecting false if password not have at least one lower letter")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "PASSWORD","JK","#$%"})
	void isPasswordHaveAtLeastSingleLowerChar_False_IfValueNotHaveAtleastOneLowerLetter(String str) {
		assertFalse(ValidationUtil.isPasswordHaveAtLeastSingleLowerChar.test(str));
	}

	@DisplayName("Expecting true if password have at least one number")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "PASSWORD","JK","#$%","password"})
	void isPasswordHaveAtLeastNumber_False_IfValueNotHaveAtleastOneLowerLetter() {
		assertFalse(ValidationUtil.isPasswordHaveAtLeastNumber.test("passWords"));
	}
}
