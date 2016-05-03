package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.AttributeListErrorType;

@SuppressWarnings("serial")
public class AttributeListNotValidException extends ServiceException{
    private final AttributeListErrorType error;

    public AttributeListNotValidException(AttributeListErrorType error) {
        super();
        this.error = error;
    }

    public AttributeListErrorType getError() {
        return error;
    }
}
