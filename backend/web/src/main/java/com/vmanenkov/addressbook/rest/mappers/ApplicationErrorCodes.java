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
    public static final String PASSWORD_TO_SIMPLE = "010";

    public static final String PASSWORD_HISTORY_ERROR = "020";
    public static final String USERNAME_DUPLICATED_ERROR = "021";
    public static final String EMAIL_DUPLICATED_ERROR = "022";
    public static final String EMAIL_IS_NOT_VALID = "023";
    public static final String EMAIL_NOT_FOUND = "024";
    public static final String ACCOUNT_NOT_FOUND = "025";


    public static final String USER_ROLE_NOT_FOUND = "100";


    public static final String ATTRIBUTE_GROUP_NOT_FOUND = "200";
    public static final String ATTRIBUTE_GROUP_NAME_IS_EMPTY = "201";
    public static final String ATTRIBUTE_GROUP_NAME_IS_NOT_UNIQIE = "203";

    public static final String ATTRIBUTE_NOT_FOUND = "210";

    public static final String ATTRIBUTE_NAME_IS_EMPTY = "220";
    public static final String ATTRIBUTE_TYPE_NOT_FOUND = "221";
    public static final String ATTRIBUTE_TYPE_NAME_IS_EMPTY = "222";
    public static final String ATTRIBUTE_TYPE_NAME_IS_NOT_UNIQUE = "223";

    public static final String ATTRIBUTE_TYPE_FIELD_TYPE_IS_EMPTY = "230";

    public static final String ATTRIBUTE_VALUE_NOT_FOUND = "231";
    public static final String ATTRIBUTE_VALUE_IS_EMPTY = "240";

    public static final String FIELD_TYPE_NOT_FOUND = "241";
    public static final String FIELD_TYPE_NAME_IS_EMPTY = "242";
    public static final String FIELD_TYPE_NAME_IS_NOT_UNIQUE = "243";

    public static final String NOTE_DATE_IS_NOT_VALID = "250";
    public static final String NOTE_VALUE_IS_EMPTY = "251";
    public static final String NOTE_NOT_FOUND = "252";

    public static final String TAG_NOT_FOUND = "260";
    public static final String TAG_NAME_IS_EMPTY = "261";


    public static final String PERSON_NOT_FOUND = "271";
    public static final String PERSON_NAME_IS_NOT_VALID = "220";
    public static final String TEST_ERROR = "990";
    public static final String ACCESS_FORBIDDEN = "991";
    public static final String IO_ERROR = "992";
    public static final String RUNTIME_EXCEPTION = "999";
}
