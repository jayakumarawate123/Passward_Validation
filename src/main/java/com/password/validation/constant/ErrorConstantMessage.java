/*
 * error constant  
 * 
 * @author Jayakumar
 * 
 */
package com.password.validation.constant;

public class ErrorConstantMessage {

	private ErrorConstantMessage() {
	}
	
	public static final String SUCCESS = "OK";
	public static final String PASSWORD_SHOULD_NOT_NULL = "password should not be null";
	public static final String PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_LOWERCASE_LETTER = "password should have one lower letter at least";
	public static final String PASSWORD_SHOULD_HAVE_AT_LEAST_ONE_UPPERCASE_CHAR_OR_ONE_NUMBER_OR_ATLEAST_EIGHT_CHAR = "password should have at least one uppercase letter or number or atleast 8 character";
	public static final String INTERNAL_SERVER_ERROR = "Internal server error";
}
