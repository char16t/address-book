package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.AttributeGroupErrorType;

@SuppressWarnings("serial")
public class AttributeGroupNotValidException extends ServiceException {

    private final AttributeGroupErrorType error;

    public AttributeGroupNotValidException(AttributeGroupErrorType error) {
        super();
        this.error = error;
    }

    public AttributeGroupErrorType getError() {
        return error;
    }
}
