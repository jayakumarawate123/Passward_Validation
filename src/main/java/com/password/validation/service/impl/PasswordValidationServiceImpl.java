/*
 * Password validation 
 * 
 * @author Jayakumar
 * 
 */

package com.password.validation.service.impl;

import static com.password.validation.constant.ErrorConstantMessage.PASSWORD_SHOULD_NOT_NULL;
import static com.password.validation.util.ValidationUtil.isNull;

import com.password.validation.exception.PasswordValidationException;
import com.password.validation.service.PasswordValidationService;

public class PasswordValidationServiceImpl implements PasswordValidationService {

	public String validatePassword(final String password) throws PasswordValidationException {

		if (isNull.test(password)) {
			throw new PasswordValidationException(PASSWORD_SHOULD_NOT_NULL);
		}
		return null;
	}

}
