package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeListValueNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeListValueNotFoundMapper implements ExceptionMapper<AttributeListValueNotFoundException>{
    
    @Inject
    private LoggerAB log;
    
    @Override
    public Response toResponse(AttributeListValueNotFoundException exception) {
        log.fine("JsonParseExceptionMapper: {0}", exception.getMessage());

        // Build result
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        RestError restError = new RestError(ApplicationErrorCodes.ATTRIBUTE_LIST_VALUE_NOT_FOUND, "AttributeListValue not found in DB");
        builder.entity(restError);
        return builder.build();
    }
}
