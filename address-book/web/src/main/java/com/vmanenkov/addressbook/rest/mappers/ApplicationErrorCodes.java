package com.vmanenkov.addressbook.rest.mappers;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationErrorCodes {

	public static final String USER_NOT_VALID = "001";
	public static final String TOKEN_GENERATION_ERROR = "003";
	public static final String INVALID_TOKEN = "004";
	public static final String NEW_PASSWORD_REQUIRED = "027";
	public static final String USER_LOCKED = "028";
	public static final String CREDENTIAL_NOT_VALID = "029";
	public static final String CREDENTIAL_REQUEST_TOKEN_NOT_VALID = "030";
	public static final String PASSWORD_SIZE_ERROR = "031";
	public static final String PASSWORD_INVALID_CHARACTER_ERROR = "032";
	public static final String PASSWORD_HISTORY_ERROR = "033";
	public static final String USERNAME_DUPLICATED_ERROR = "034";
	public static final String EMAIL_DUPLICATED_ERROR = "035";
	public static final String ACCOUNT_NOT_FOUND = "036";
	public static final String TOKEN_INVALID = "062";
	public static final String EMAIL_NOT_FOUND = "077";
	public static final String TEST_ERROR = "990";
	public static final String ACCESS_FORBIDDEN = "991";
	public static final String IO_ERROR = "992";
	public static final String RUNTIME_EXCEPTION = "999";
}
