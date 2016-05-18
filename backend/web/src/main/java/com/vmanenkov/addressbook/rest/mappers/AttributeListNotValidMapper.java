package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeListNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeListErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeListNotValidMapper implements ExceptionMapper<AttributeListNotValidException>{
    
    @Inject
    private LoggerAB log;    
    
    @Override
    public Response toResponse(AttributeListNotValidException exception) {
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        AttributeListErrorType error = exception.getError();
        switch (error) {
            case ATTRIBUTE_LIST_NAME_IS_EMPTY:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_LIST_NAME_IS_EMPTY;
                description = "AttributeList name should not be empty";
                break;
            case ATTRIBUTE_LIST_NAME_IS_NOT_UNIQIE:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_LIST_NAME_IS_NOT_UNIQIE;
                description = "AttributeList name should be unique";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}
