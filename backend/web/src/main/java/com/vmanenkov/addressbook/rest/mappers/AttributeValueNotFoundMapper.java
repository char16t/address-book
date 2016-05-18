package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeValueNotFoundMapper implements ExceptionMapper<AttributeValueNotFoundException>{
    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(AttributeValueNotFoundException exception) {
        log.fine("JsonParseExceptionMapper: {0}", exception.getMessage());

        // Build result
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        RestError restError = new RestError(ApplicationErrorCodes.ATTRIBUTE_VALUE_NOT_FOUND, "Attribute Value not found in DB");
        builder.entity(restError);
        return builder.build();
    }
}
