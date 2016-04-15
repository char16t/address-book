package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.PersonNotValidException;
import com.vmanenkov.services.exceptions.errortypes.PersonErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonNotValidMapper implements ExceptionMapper<PersonNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(PersonNotValidException exception) {
        ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        PersonErrorType error = exception.getError();
        switch (error) {
            case PERSON_FIRST_NAME_IS_EMPTY:
            case PERSON_LAST_NAME_IS_EMPTY:
                errorCode = ApplicationErrorCodes.PERSON_NAME_IS_NOT_VALID;
                description = "First and/or last names should not be empty";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}