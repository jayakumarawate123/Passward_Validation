/*
 * Password validation 
 * 
 * @author Jayakumar
 * 
 */

package com.password.validation.service.impl;

import static com.password.validation.constant.ErrorConstantMessage.*;
import static com.password.validation.util.ValidationUtil.*;

import com.password.validation.exception.PasswordValidationException;
import com.password.validation.service.PasswordValidationService;

public class PasswordValidationServiceImpl implements PasswordValidationService {

	public String validatePassword(final String password) throws PasswordValidationException {

		if (isNull.test(password)) {
			throw new PasswordValidationException(PASSWORD_SHOULD_NOT_NULL);
		}

		return checkPasswordHasMandatoryLetter(password);
	}
	
	/**
	 * Method for checking the password has required letter or not
	 * 
	 * @param password
	 * @return
	 */
	private String checkPasswordHasMandatoryLetter(final String password) {
		if (!isPasswordHaveAtLeastSingleLowerChar.test(password)) {
			throw new PasswordValidationException(PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_LOWERCASE_LETTER);
		} else if (!isPasswordLengthLessThanEight.test(password) || isPasswordHaveAtLeastSingleUpperChar.test(password)
				|| isPasswordHaveAtLeastNumber.test(password)) {
			return SUCCESS;
		} else {
			throw new PasswordValidationException(
					PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_UPPERCASE_CHAR_OR_ONE_NUMBER_OR_ATLEAST_EIGHT_CHAR);
		}
	}

}
