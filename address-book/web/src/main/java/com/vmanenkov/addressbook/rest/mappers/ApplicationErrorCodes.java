package com.vmanenkov.addressbook.rest.mappers;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationErrorCodes {

    public static final String USER_NOT_VALID = "001";
    public static final String TOKEN_GENERATION_ERROR = "002";
    public static final String INVALID_TOKEN = "003";
    public static final String NEW_PASSWORD_REQUIRED = "004";
    public static final String USER_LOCKED = "005";
    public static final String CREDENTIAL_NOT_VALID = "006";
    public static final String CREDENTIAL_REQUEST_TOKEN_NOT_VALID = "007";
    public static final String PASSWORD_SIZE_ERROR = "008";
    public static final String PASSWORD_INVALID_CHARACTER_ERROR = "009";
    public static final String PASSWORD_HISTORY_ERROR = "010";
    public static final String USERNAME_DUPLICATED_ERROR = "011";
    public static final String EMAIL_DUPLICATED_ERROR = "012";
    public static final String EMAIL_NOT_FOUND = "013";
    public static final String ACCOUNT_NOT_FOUND = "014";

    public static final String USER_ROLE_NOT_FOUND = "100";

    public static final String TEST_ERROR = "990";
    public static final String ACCESS_FORBIDDEN = "991";
    public static final String IO_ERROR = "992";
    public static final String RUNTIME_EXCEPTION = "999";
}
