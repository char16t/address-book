package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.addressbook.rest.model.contacts.FieldTypeRest;
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
    private FieldTypeService fieldTypeService;

    @POST
    @NoCache
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public FieldTypeRest createFieldType(FieldTypeRest rest) throws FieldTypeNotValidException {
        return convertToRest(fieldTypeService.create(rest.getTypeName()));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FieldTypeRest readFieldType(@PathParam("id") Long id) throws FieldTypeNotFoundException {
        return convertToRest(fieldTypeService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FieldTypeRest updateFieldType(@PathParam("id") Long id, FieldTypeRest rest) throws FieldTypeNotValidException, FieldTypeNotFoundException {
        return convertToRest(fieldTypeService.update(id, rest.getTypeName()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFieldType(@PathParam("id") Long id) throws FieldTypeNotFoundException {
        fieldTypeService.delete(id);
    }

    private FieldTypeRest convertToRest(FieldType fieldType) {
        return new FieldTypeRest(
                fieldType.getId(),
                fieldType.getTypeName()
        );
    }
}
