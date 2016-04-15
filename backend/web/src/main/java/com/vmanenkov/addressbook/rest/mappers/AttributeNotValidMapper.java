package com.vmanenkov.addressbook.rest.mappers;


import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeNotValidMapper implements ExceptionMapper<AttributeNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(AttributeNotValidException exception) {
        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        AttributeErrorType error = exception.getError();
        switch (error) {
            case ATTRIBUTE_NAME_IS_EMPTY:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_NAME_IS_EMPTY;
                description = "Attribute name should not be empty";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}