/*
 * 
 * Test cases for validating the util
 * 
 *  @author Jayakumar
 *  
 */

package com.password.validation.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A test class for validation util class methods")
class ValidationUtilTest {

	@DisplayName("Expecting true if value is null else false")
	@Test
	void isNull_True_ifValueNull() {
		assertTrue(ValidationUtil.isNull.test(null));
	}
}
