package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.FieldTypeRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.FieldTypeService;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashSet;

@Path("/field_types")
@RequestScoped
@Profiled
public class FieldTypeRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private FieldTypeService fieldTypeService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createFieldType(FieldTypeRest rest) throws FieldTypeNotValidException {
        log.fine("createFieldType(FieldTypeRest rest = {0})", rest);
        FieldType fieldType = fieldTypeService.create(rest.getTypeName());
        return converter.convertToRest(fieldType);
    }

    @GET
    @NoCache
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<FieldTypeRest> getAllAttributeGroup() {
        log.fine("getAllAttributeGroup()");
        return convertToRests(fieldTypeService.getAll());
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity readFieldType(@PathParam("id") Long id) throws FieldTypeNotFoundException {
        log.fine("readFieldType(@PathParam(\"id\") Long id = {0})", id);
        FieldType fieldType = fieldTypeService.get(id);
        return converter.convertToRest(fieldType);
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateFieldType(
            FieldTypeRest rest,
            @PathParam("id") Long id)
            throws FieldTypeNotValidException, FieldTypeNotFoundException {
        log.fine("updateFieldType(\n" +
                         "            FieldTypeRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1})", rest, id);
        FieldType fieldType = fieldTypeService.update(id, rest.getTypeName());
        return converter.convertToRest(fieldType);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteFieldType(@PathParam("id") Long id) throws FieldTypeNotFoundException {
        log.fine("deleteFieldType(@PathParam(\"id\") Long id = {0})", id);
        fieldTypeService.delete(id);
    }

    private Collection<FieldTypeRest> convertToRests(Collection<FieldType> models) {
        Collection<FieldTypeRest> rests = new HashSet<>(models.size());
        for (FieldType model : models) {
            rests.add((FieldTypeRest) converter.convertToRest(model));
        }
        return rests;
    }
}
