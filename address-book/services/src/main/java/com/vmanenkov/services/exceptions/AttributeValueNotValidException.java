package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.AttributeValueErrorType;

@SuppressWarnings("serial")
public class AttributeValueNotValidException extends ServiceException {

    private final AttributeValueErrorType error;

    public AttributeValueNotValidException(AttributeValueErrorType error) {
        super();
        this.error = error;
    }

    public AttributeValueErrorType getError() {
        return error;
    }
}
