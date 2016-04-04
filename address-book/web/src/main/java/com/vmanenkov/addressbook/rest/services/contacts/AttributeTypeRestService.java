package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeTypeRest;
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
    private AttributeTypeService attributeTypeService;

    @Inject
    private FieldTypeService fieldTypeService;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeTypeRest createAttributeType(
            AttributeTypeRest rest,
            @QueryParam("field_type_id") Long fieldTypeId)
            throws FieldTypeNotFoundException, AttributeTypeNotValidException {
        FieldType fieldType = fieldTypeService.get(fieldTypeId);

        return convertToRest(attributeTypeService.create(rest.getName(), fieldType));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeTypeRest readAttributeType(@PathParam("id") Long id)
            throws AttributeTypeNotFoundException {
        return convertToRest(attributeTypeService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeTypeRest updateAttributeType(
            AttributeTypeRest rest,
            @PathParam("id") Long id,
            @QueryParam("field_type_id") Long fieldTypeId
    ) throws FieldTypeNotFoundException, AttributeTypeNotValidException, AttributeTypeNotFoundException {
        FieldType fieldType = fieldTypeService.get(fieldTypeId);
        return convertToRest(attributeTypeService.update(id, rest.getName(), fieldType));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteAttributeType(@PathParam("id") Long id) throws AttributeTypeNotFoundException {
        attributeTypeService.delete(id);
    }

    private AttributeTypeRest convertToRest(AttributeType attributeType) {
        return new AttributeTypeRest(
                attributeType.getId(),
                attributeType.getName()
        );
    }
}
