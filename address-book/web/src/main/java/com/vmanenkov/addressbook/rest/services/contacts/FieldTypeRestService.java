package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.addressbook.rest.model.contacts.FieldTypeRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.addressbook.utils.EntityConverterImpl;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.FieldTypeService;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/field_types")
@RequestScoped
@Profiled
public class FieldTypeRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private FieldTypeService fieldTypeService;

    private EntityConverter converter = new EntityConverterImpl();

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public FieldTypeRest createFieldType(FieldTypeRest rest) throws FieldTypeNotValidException {
        log.fine("createFieldType(FieldTypeRest rest = {0})", rest);
        FieldType fieldType = fieldTypeService.create(rest.getTypeName());
        return (FieldTypeRest) converter.convertToRest(fieldType);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public FieldTypeRest readFieldType(@PathParam("id") Long id) throws FieldTypeNotFoundException {
        log.fine("readFieldType(@PathParam(\"id\") Long id = {0})", id);
        FieldType fieldType = fieldTypeService.get(id);
        return (FieldTypeRest) converter.convertToRest(fieldType);
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public FieldTypeRest updateFieldType(
            FieldTypeRest rest,
            @PathParam("id") Long id)
            throws FieldTypeNotValidException, FieldTypeNotFoundException {
        log.fine("updateFieldType(\n" +
                         "            FieldTypeRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1})", rest, id);
        FieldType fieldType = fieldTypeService.update(id, rest.getTypeName());
        return (FieldTypeRest) converter.convertToRest(fieldType);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteFieldType(@PathParam("id") Long id) throws FieldTypeNotFoundException {
        log.fine("deleteFieldType(@PathParam(\"id\") Long id = {0})", id);
        fieldTypeService.delete(id);
    }

    // TODO: Remove this
    private FieldTypeRest convertToRest(FieldType fieldType) {
        return new FieldTypeRest(
                fieldType.getId(),
                fieldType.getTypeName()
        );
    }
}
