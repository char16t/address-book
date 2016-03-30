package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.AttributeGroupNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AttributeGroupNotFoundMapper implements ExceptionMapper<AttributeGroupNotFoundException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(AttributeGroupNotFoundException exception) {
        log.fine("JsonParseExceptionMapper: {0}", exception.getMessage());

        // Build result
        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        RestError restError = new RestError(ApplicationErrorCodes.ATTRIBUTE_GROUP_NOT_FOUND, "Attribute group not found in DB");
        builder.entity(restError);
        return builder.build();
    }
}