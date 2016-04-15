package com.vmanenkov.addressbook.rest.mappers;

import com.vmanenkov.addressbook.rest.model.RestError;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.TestDisabledException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TestDisabledMapper implements ExceptionMapper<TestDisabledException> {

	@Inject
	private LoggerAB log;

	@Override
	public Response toResponse(TestDisabledException exception) {

		log.fine("JsonParseExceptionMapper: {0}", exception.getMessage());

		// Build result
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		RestError restError = new RestError(ApplicationErrorCodes.RUNTIME_EXCEPTION, "Internal Error");
		builder.entity(restError);
		return builder.build();
	}
}