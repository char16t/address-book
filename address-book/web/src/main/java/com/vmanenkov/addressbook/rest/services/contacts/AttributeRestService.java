package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeGroupService;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.contacts.AttributeTypeService;
import com.vmanenkov.services.exceptions.*;
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
    private LoggerAB log;

    @Inject
    private AttributeService attributeService;

    @Inject
    private AttributeTypeService attributeTypeService;

    @Inject
    private AttributeGroupService attributeGroupService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createAttribute(
            AttributeRest rest,
            @QueryParam("type_id") Long typeId,
            @QueryParam("group_id") Long groupId) throws AttributeTypeNotFoundException, AttributeGroupNotFoundException, AttributeNotValidException, PersonNotFoundException {

        log.fine("createAttribute(\n" +
                         "            AttributeRest rest = {0},\n" +
                         "            @QueryParam(\"type_id\") Long typeId = {1},\n" +
                         "            @QueryParam(\"group_id\") Long groupId = {2}", rest, typeId, groupId);
        AttributeType attributeType = attributeTypeService.get(typeId);
        AttributeGroup attributeGroup = attributeGroupService.get(groupId);
        Attribute attribute = attributeService.create(rest.getName(), rest.getDescription(),
                                                      attributeGroup, attributeType);
        return converter.convertToRest(attribute);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readAttribute(@PathParam("id") Long id) throws AttributeNotFoundException {
        log.fine("readAttribute(@PathParam(\"id\") Long id = {0})", id);
        return converter.convertToRest(attributeService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateAttribute(
            AttributeRest rest,
            @PathParam("id") Long id,
            @QueryParam("type_id") Long typeId,
            @QueryParam("group_id") Long groupId) throws AttributeTypeNotFoundException, AttributeGroupNotFoundException, AttributeNotValidException, AttributeNotFoundException {
        log.fine("updateAttribute(\n" +
                         "            AttributeRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1},\n" +
                         "            @QueryParam(\"type_id\") Long typeId = {2},\n" +
                         "            @QueryParam(\"group_id\") Long groupId = {3})", rest, typeId, groupId);
        AttributeType attributeType = attributeTypeService.get(typeId);
        AttributeGroup attributeGroup = attributeGroupService.get(groupId);
        Attribute attribute = attributeService.update(id, rest.getName(), rest.getDescription(),
                                                      attributeGroup, attributeType);
        return converter.convertToRest(attribute);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAttribute(@PathParam("id") Long id) throws AttributeNotFoundException {
        log.fine("deleteAttribute(@PathParam(\"id\") Long id = {0})", id);
        attributeService.delete(id);
    }
}
