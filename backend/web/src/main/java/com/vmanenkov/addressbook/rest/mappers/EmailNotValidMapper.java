package com.vmanenkov.addressbook.rest.mappers;


import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.EmailNotValidException;
import com.vmanenkov.services.exceptions.errortypes.EmailErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmailNotValidMapper implements ExceptionMapper<EmailNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(EmailNotValidException exception) {
        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        EmailErrorType error = exception.getError();
        switch (error) {
            case EMAIL_IS_NOT_UNIQUE:
                errorCode = ApplicationErrorCodes.EMAIL_DUPLICATED_ERROR;
                description = "Email should be unique";
                break;

            case EMAIL_IS_EMPTY:
            case EMAIL_IS_NOT_VALID:
                errorCode = ApplicationErrorCodes.EMAIL_IS_NOT_VALID;
                description = "Email is not valid";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}