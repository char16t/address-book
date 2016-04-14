package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeGroupNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeGroupErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeGroupNotValidMapper implements ExceptionMapper<AttributeGroupNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(AttributeGroupNotValidException exception) {
        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        AttributeGroupErrorType error = exception.getError();
        switch (error) {
            case ATTRIBUTE_GROUP_NAME_IS_EMPTY:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_GROUP_NAME_IS_EMPTY;
                description = "Attribute group name should not be empty";
                break;
            case ATTRIBUTE_GROUP_NAME_IS_NOT_UNIQIE:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_GROUP_NAME_IS_NOT_UNIQIE;
                description = "Attribute group name should be unique";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}