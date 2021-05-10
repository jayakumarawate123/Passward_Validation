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
	 * Validating given string length return true if string length is less than 8
	 * else false
	 */
	public static final Predicate<String> isPasswordLengthLessThanEight = str -> str.length() <= 8;
	
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
	
	/**
	 * Validating given string have atleast one number return true if string have
	 * atleast one number else false
	 */
	public static final Predicate<String> isPasswordHaveAtLeastNumber = str -> {
		String regex = "(.*[0-9].*)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	};

	/**
	 * Validating given string have atleast single upper char return true if string
	 * have atleast single upper char else false
	 */
	public static final Predicate<String> isPasswordHaveAtLeastSingleUpperChar = str -> {
		String regex = "(.*[A-Z].*)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.matches();
	};


}
