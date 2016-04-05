package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.TagNotValidException;
import com.vmanenkov.services.exceptions.errortypes.TagErrorType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TagNotValidMapper  implements ExceptionMapper<TagNotValidException> {

    @Inject
    private LoggerAB log;

    @Override
    public Response toResponse(TagNotValidException exception) {
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        String errorCode = null;
        String description = null;
        TagErrorType error = exception.getError();
        switch (error) {
            case TAG_NAME_IS_EMPTY:
                errorCode = ApplicationErrorCodes.TAG_NAME_IS_EMPTY;
                description = "Tag name should not be empty";
                break;
            default:
                break;
        }
        RestError restError = new RestError(errorCode, description);
        builder.entity(restError);
        return builder.build();
    }
}
