/*
 * @author Jayakumar
 * 
 */

package com.password.validation.util;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	private ValidationUtil(){}
	/**
	 * Validating given string is null or not return true if string is null else
	 * false
	 */
	public static final Predicate<String> isNull = Objects::isNull;
	
	/**
	 * Validating given string have atleast single lower char return true if string
	 * have atleast single lower char else false
	 */
	public static final Predicate<String> isPasswordHaveAtLeastSingleLowerChar = str -> {
		String regex = "(.*[a-z].*)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	};

}
