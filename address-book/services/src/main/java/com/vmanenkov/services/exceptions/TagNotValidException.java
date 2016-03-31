package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.TagErrorType;

@SuppressWarnings("serial")
public class TagNotValidException extends ServiceException {

    private final TagErrorType error;

    public TagNotValidException(TagErrorType error) {
        super();
        this.error = error;
    }

    public TagErrorType getError() {
        return error;
    }
}
