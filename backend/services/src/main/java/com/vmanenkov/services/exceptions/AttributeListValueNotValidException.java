package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.AttributeListValueErrorType;

@SuppressWarnings("serial")
public class AttributeListValueNotValidException extends ServiceException{
    private final AttributeListValueErrorType error;

    public AttributeListValueNotValidException(AttributeListValueErrorType error) {
        super();
        this.error = error;
    }

    public AttributeListValueErrorType getError() {
        return error;
    }
}
