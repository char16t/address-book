package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeListValueNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeListValueErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeListValueNotValidMapper implements ExceptionMapper<AttributeListValueNotValidException>{
    
    @Inject
    private LoggerAB log;    

    @Override
    public Response toResponse(AttributeListValueNotValidException exception) {
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        AttributeListValueErrorType error = exception.getError();
        switch (error) {
            case ATTRIBUTE_LIST_VALUE_IS_EMPTY:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_LIST_VALUE_IS_EMPTY;
                description = "AttributeListValue value should not be empty";
                break;
            case ATTRIBUTE_LIST_VALUE_IS_NOT_UNIQIE:
                errorCode = ApplicationErrorCodes.ATTRIBUTE_LIST_VALUE_IS_NOT_UNIQIE;
                description = "AttributeListValue value already exists in this AttributeList";
                break;                
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
    
}
