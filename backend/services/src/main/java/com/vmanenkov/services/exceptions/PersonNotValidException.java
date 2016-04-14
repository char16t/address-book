package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.PersonErrorType;

@SuppressWarnings("serial")
public class PersonNotValidException extends ServiceException {

    private final PersonErrorType error;

    public PersonNotValidException(PersonErrorType error) {
        super();
        this.error = error;
    }

    public PersonErrorType getError() {
        return error;
    }
}