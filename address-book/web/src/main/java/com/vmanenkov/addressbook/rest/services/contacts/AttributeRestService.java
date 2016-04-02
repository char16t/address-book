package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeGroupRest;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeRest;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeTypeRest;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeGroupService;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.contacts.AttributeTypeService;
import com.vmanenkov.services.exceptions.AttributeGroupNotFoundException;
import com.vmanenkov.services.exceptions.AttributeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeNotValidException;
import com.vmanenkov.services.exceptions.AttributeTypeNotFoundException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/attributes")
@RequestScoped
@Profiled
public class AttributeRestService {

    @Inject
    private AttributeService attributeService;

    @Inject
    private AttributeTypeService attributeTypeService;

    @Inject
    private AttributeGroupService attributeGroupService;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeRest createAttribute(
            AttributeRest rest,
            @QueryParam("type_id") Long typeId,
            @QueryParam("group_id") Long groupId) throws AttributeTypeNotFoundException, AttributeGroupNotFoundException, AttributeNotValidException {

        AttributeType attributeType = attributeTypeService.get(typeId);
        AttributeGroup attributeGroup = attributeGroupService.get(groupId);
        return convertToRest(attributeService.create(rest.getName(), rest.getDescription(), attributeGroup, attributeType));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeRest readAttribute(@PathParam("id") Long id) throws AttributeNotFoundException {
        return convertToRest(attributeService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeRest updateAttribute(
            @PathParam("id") Long id,
            AttributeRest rest,
            @QueryParam("type_id") Long typeId,
            @QueryParam("group_id") Long groupId) throws AttributeTypeNotFoundException, AttributeGroupNotFoundException, AttributeNotValidException, AttributeNotFoundException {
        AttributeType attributeType = attributeTypeService.get(typeId);
        AttributeGroup attributeGroup = attributeGroupService.get(groupId);

        return convertToRest(attributeService.update(
                id,
                rest.getName(),
                rest.getDescription(),
                attributeGroup,
                attributeType
            )
        );
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAttribute(@PathParam("id") Long id) throws AttributeNotFoundException {
        attributeService.delete(id);
    }

    private AttributeRest convertToRest(Attribute attribute) {
        return new AttributeRest(
                attribute.getId(),
                attribute.getName(),
                attribute.getDescription(),
                new AttributeGroupRest (attribute.getAttributeGroup().getId(), attribute.getAttributeGroup().getName(), attribute.getAttributeGroup().getDescription()),
                new AttributeTypeRest(attribute.getAttributeType().getId(), attribute.getAttributeGroup().getName())
        );
    }
}
