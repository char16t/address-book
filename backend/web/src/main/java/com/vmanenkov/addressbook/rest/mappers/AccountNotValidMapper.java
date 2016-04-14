package com.vmanenkov.addressbook.rest.mappers;


import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AccountNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AccountErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AccountNotValidMapper implements ExceptionMapper<AccountNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(AccountNotValidException exception) {
        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        AccountErrorType error = exception.getError();
        switch (error) {
            case PASSWORD_IS_EMPTY:
            case PASSWORD_IS_TOO_LONG:
                errorCode = ApplicationErrorCodes.PASSWORD_SIZE_ERROR;
                description = "Password is empty or too long";
                break;
            case PASSWORD_INVALID_CHARACTER_ERROR:
                errorCode = ApplicationErrorCodes.PASSWORD_INVALID_CHARACTER_ERROR;
                description = "Password contains invalid character";
                break;
            case PASSWORD_IS_TOO_SIMPLE:
            case PASSWORD_IS_TOO_SMALL:
                errorCode = ApplicationErrorCodes.PASSWORD_TO_SIMPLE;
                description = "Password is too simple";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}