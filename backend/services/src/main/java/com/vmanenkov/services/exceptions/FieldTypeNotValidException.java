package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.FieldTypeErrorType;

@SuppressWarnings("serial")
public class FieldTypeNotValidException extends ServiceException {

    private final FieldTypeErrorType error;

    public FieldTypeNotValidException(FieldTypeErrorType error) {
        super();
        this.error = error;
    }

    public FieldTypeErrorType getError() {
        return error;
    }
}
