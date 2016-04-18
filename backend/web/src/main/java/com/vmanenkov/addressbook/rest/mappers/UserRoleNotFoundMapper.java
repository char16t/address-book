package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.UserRoleNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserRoleNotFoundMapper implements ExceptionMapper<UserRoleNotFoundException> {

	@Inject
	private LoggerAB log;

	@Override
	public Response toResponse(UserRoleNotFoundException exception) {
		log.fine("JsonParseExceptionMapper: {0}", exception.getMessage());

		// Build result
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		RestError restError = new RestError(ApplicationErrorCodes.USER_ROLE_NOT_FOUND, "Role not found");
		builder.entity(restError);
		return builder.build();
	}
}