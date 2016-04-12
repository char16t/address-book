package com.vmanenkov.services.exceptions.errortypes;


public enum AccountErrorType {
    EMAIL_IS_EMPTY,
    EMAIL_IS_NOT_UNIQUE,
    EMAIL_IS_NOT_VALID,
    PASSWORD_IS_EMPTY,
    PASSWORD_INVALID_CHARACTER_ERROR,
    PASSWORD_IS_TOO_SMALL,
    PASSWORD_IS_TOO_LONG,
    PASSWORD_IS_TOO_SIMPLE
}
