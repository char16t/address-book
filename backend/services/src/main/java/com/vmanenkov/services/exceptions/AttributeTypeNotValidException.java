package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.AttributeTypeErrorType;

@SuppressWarnings("serial")
public class AttributeTypeNotValidException extends ServiceException {

    private final AttributeTypeErrorType error;

    public AttributeTypeNotValidException(AttributeTypeErrorType error) {
        super();
        this.error = error;
    }

    public AttributeTypeErrorType getError() {
        return error;
    }
}
