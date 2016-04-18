package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FieldTypeNotFoundMapper implements ExceptionMapper<FieldTypeNotFoundException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(FieldTypeNotFoundException exception) {
        log.fine("JsonParseExceptionMapper: {0}", exception.getMessage());

        // Build result
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        RestError restError = new RestError(ApplicationErrorCodes.FIELD_TYPE_NOT_FOUND, "Field type not found in DB");
        builder.entity(restError);
        return builder.build();
    }
}
