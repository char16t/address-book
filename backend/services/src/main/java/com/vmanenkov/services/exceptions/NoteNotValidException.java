package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.NoteErrorType;

@SuppressWarnings("serial")
public class NoteNotValidException extends ServiceException {

    private final NoteErrorType error;

    public NoteNotValidException(NoteErrorType error) {
        super();
        this.error = error;
    }

    public NoteErrorType getError() {
        return error;
    }
}
