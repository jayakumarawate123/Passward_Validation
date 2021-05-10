/*
 * Password validation 
 * 
 * @author Jayakumar
 * 
 */

package com.password.validation.service.impl;

import static com.password.validation.constant.ErrorConstantMessage.*;
import static com.password.validation.util.ValidationUtil.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.password.validation.exception.ApplicationException;
import com.password.validation.exception.PasswordValidationException;
import com.password.validation.service.PasswordValidationService;

public class PasswordValidationServiceImpl implements PasswordValidationService {

	ExecutorService executorsService = Executors.newFixedThreadPool(5);
	
	public String validatePassword(final String password) {

		Future<String> result = executorsService.submit(() -> {
			if (isNull.test(password)) {
				throw new PasswordValidationException(PASSWORD_SHOULD_NOT_NULL);
			}
			return checkPasswordHasMandatoryLetter(password);
		});

		return getValueFromFutureObject(result);
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
	
	/**
	 * Method for getting the value from the future object
	 * 
	 * @param result
	 * @return
	 */
	private String getValueFromFutureObject(Future<String> result) {
		try {
			return result.get();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new ApplicationException(INTERNAL_SERVER_ERROR);
		} catch (ExecutionException e) {
			if (e.getCause().getClass() == PasswordValidationException.class) {
				throw new PasswordValidationException(e.getCause().getMessage());
			} else {
				throw new ApplicationException(INTERNAL_SERVER_ERROR);
			}
		}
	}

}
