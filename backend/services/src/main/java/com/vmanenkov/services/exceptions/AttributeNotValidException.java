package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.AttributeErrorType;

@SuppressWarnings("serial")
public class AttributeNotValidException extends ServiceException {

    private final AttributeErrorType error;

    public AttributeNotValidException(AttributeErrorType error) {
        super();
        this.error = error;
    }

    public AttributeErrorType getError() {
        return error;
    }
}
