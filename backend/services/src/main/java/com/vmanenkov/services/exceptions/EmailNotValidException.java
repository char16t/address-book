package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.EmailErrorType;

@SuppressWarnings("serial")
public class EmailNotValidException extends ServiceException {

    private final EmailErrorType error;

    public EmailNotValidException(EmailErrorType error) {
        super();
        this.error = error;
    }

    public EmailErrorType getError() {
        return error;
    }
}
