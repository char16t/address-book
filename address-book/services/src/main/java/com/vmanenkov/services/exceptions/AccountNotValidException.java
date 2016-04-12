package com.vmanenkov.services.exceptions;

import com.vmanenkov.services.exceptions.errortypes.AccountErrorType;

@SuppressWarnings("serial")
public class AccountNotValidException extends ServiceException {

    private final AccountErrorType error;

    public AccountNotValidException(AccountErrorType error) {
        super();
        this.error = error;
    }

    public AccountErrorType getError() {
        return error;
    }
}
