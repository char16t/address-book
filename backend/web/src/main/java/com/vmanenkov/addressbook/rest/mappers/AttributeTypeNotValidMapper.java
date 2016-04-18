package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeTypeNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeTypeErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeTypeNotValidMapper implements ExceptionMapper<AttributeTypeNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(AttributeTypeNotValidException exception) {
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        AttributeTypeErrorType error = exception.getError();
        switch (error) {
            case ATTRIBUTE_TYPE_NAME_IS_EMPTY:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_TYPE_NAME_IS_EMPTY;
                description = "Attribute type name should not be empty";
                break;
            case ATTRIBUTE_TYPE_FIELD_TYPE_IS_EMPTY:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_TYPE_FIELD_TYPE_IS_EMPTY;
                description = "Attribute type field type should not be empty";
                break;
            case ATTRIBUTE_TYPE_NAME_IS_NOT_UNIQUE:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_TYPE_NAME_IS_NOT_UNIQUE;
                description = "Attribute type name should be unique";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}
