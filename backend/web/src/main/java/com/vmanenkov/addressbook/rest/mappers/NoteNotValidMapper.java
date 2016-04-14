package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.NoteNotValidException;
import com.vmanenkov.services.exceptions.errortypes.NoteErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NoteNotValidMapper implements ExceptionMapper<NoteNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(NoteNotValidException exception) {
        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        NoteErrorType error = exception.getError();
        switch (error) {
            case DATE_NOT_VALID:
                errorCode = ApplicationErrorCodes.NOTE_DATE_IS_NOT_VALID;
                description = "Not valid date";
                break;
            case NOTE_VALUE_IS_EMPTY:
                errorCode = ApplicationErrorCodes.NOTE_VALUE_IS_EMPTY;
                description = "Note value should not be empty";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}