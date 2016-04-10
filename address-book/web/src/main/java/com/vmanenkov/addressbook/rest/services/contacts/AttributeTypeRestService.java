package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeTypeRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeTypeService;
import com.vmanenkov.services.contacts.FieldTypeService;
import com.vmanenkov.services.exceptions.AttributeTypeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeTypeNotValidException;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/attribute_types")
@RequestScoped
@Profiled
public class AttributeTypeRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private AttributeTypeService attributeTypeService;

    @Inject
    private FieldTypeService fieldTypeService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createAttributeType(
            AttributeTypeRest rest,
            @QueryParam("field_type_id") Long fieldTypeId)
            throws FieldTypeNotFoundException, AttributeTypeNotValidException {
        log.fine("createAttributeType(\n" +
                         "            AttributeTypeRest rest = {0},\n" +
                         "            @QueryParam(\"field_type_id\") Long fieldTypeId = {1})", rest, fieldTypeId);
        FieldType fieldType = fieldTypeService.get(fieldTypeId);
        return converter.convertToRest(attributeTypeService.create(rest.getName(), fieldType));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readAttributeType(@PathParam("id") Long id)
            throws AttributeTypeNotFoundException {
        log.fine("readAttributeType(@PathParam(\"id\") Long id = {0})", id);
        return converter.convertToRest(attributeTypeService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateAttributeType(
            AttributeTypeRest rest,
            @PathParam("id") Long id,
            @QueryParam("field_type_id") Long fieldTypeId)
            throws FieldTypeNotFoundException, AttributeTypeNotValidException, AttributeTypeNotFoundException {
        log.fine("updateAttributeType(\n" +
                         "            AttributeTypeRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1},\n" +
                         "            @QueryParam(\"field_type_id\") Long fieldTypeId = {2})", rest, id, fieldTypeId);
        FieldType fieldType = fieldTypeService.get(fieldTypeId);
        return converter.convertToRest(attributeTypeService.update(id, rest.getName(), fieldType));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAttributeType(@PathParam("id") Long id) throws AttributeTypeNotFoundException {
        log.fine("deleteAttributeType(@PathParam(\"id\") Long id = {0})", id);
        attributeTypeService.delete(id);
    }

}
