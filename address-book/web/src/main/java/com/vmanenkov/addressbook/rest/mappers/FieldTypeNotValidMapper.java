package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;
import com.vmanenkov.services.exceptions.errortypes.FieldTypeErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FieldTypeNotValidMapper implements ExceptionMapper<FieldTypeNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(FieldTypeNotValidException exception) {
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        FieldTypeErrorType error = exception.getError();
        switch (error) {
            case FIELD_TYPE_NAME_IS_EMPTY:
                errorCode = ApplicationErrorCodes.FIELD_TYPE_NAME_IS_EMPTY;
                description = "Field type name should not be empty";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}
