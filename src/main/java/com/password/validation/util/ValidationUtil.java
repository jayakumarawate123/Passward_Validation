/*
 * @author Jayakumar
 * 
 */

package com.password.validation.util;

import java.util.Objects;
import java.util.function.Predicate;

public class ValidationUtil {

	private ValidationUtil(){}
	/**
	 * Validating given string is null or not return true if string is null else
	 * false
	 */
	public static final Predicate<String> isNull = Objects::isNull;

}
