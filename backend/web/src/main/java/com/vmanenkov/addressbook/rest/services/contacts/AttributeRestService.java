package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeGroupService;
import com.vmanenkov.services.contacts.AttributeListService;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.contacts.AttributeTypeService;
import com.vmanenkov.services.exceptions.*;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashSet;

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
    private AttributeListService attributeListService;
    
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
            @QueryParam("group_id") Long groupId,
            @QueryParam("list_id") Long listId) 
            throws AttributeTypeNotFoundException, AttributeGroupNotFoundException, AttributeNotValidException, 
            PersonNotFoundException, AttributeListNotFoundException {

        log.fine("createAttribute(\n" +
                         "            AttributeRest rest = {0},\n" +
                         "            @QueryParam(\"type_id\") Long typeId = {1},\n" +
                         "            @QueryParam(\"group_id\") Long groupId = {2},\n" +
                         "            @QueryParam(\"list_id\") Long listId = {3}", rest, typeId, groupId, listId);
        AttributeType attributeType = attributeTypeService.get(typeId);
        AttributeGroup attributeGroup = attributeGroupService.get(groupId);
        AttributeList attributeList = null;
        if (listId != null) {
            attributeList = attributeListService.getById(listId);
        }
        Attribute attribute = attributeService.create(rest.getName(), rest.getDescription(),
                                                      attributeGroup, attributeType, attributeList);
        return converter.convertToRest(attribute);
    }

    @GET
    @NoCache
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AttributeRest> getAllAttributes() {
        log.fine("getAllAttributes()");
        return convertToRests(attributeService.getAll());
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
            @QueryParam("group_id") Long groupId,
            @QueryParam("list_id") Long listId) 
            throws AttributeTypeNotFoundException, AttributeGroupNotFoundException, AttributeNotValidException, 
            AttributeNotFoundException, AttributeListNotFoundException {
        log.fine("updateAttribute(\n" +
                         "            AttributeRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1},\n" +
                         "            @QueryParam(\"type_id\") Long typeId = {2},\n" +
                         "            @QueryParam(\"group_id\") Long groupId = {3},\n" +
                         "            @QueryParam(\"list_id\") Long listId = {4})", rest, typeId, groupId, listId);
        AttributeType attributeType = attributeTypeService.get(typeId);
        AttributeGroup attributeGroup = attributeGroupService.get(groupId);
        AttributeList attributeList = null;
        if (listId != null) {
            attributeList = attributeListService.getById(listId);
        }
        //конечно я понимаю, что при изменении id списка, может получится, что значения уже назначенные для этого атрибута станут невалидными
        Attribute attribute = attributeService.update(id, rest.getName(), rest.getDescription(),
                                                      attributeGroup, attributeType, attributeList);
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

    private Collection<AttributeRest> convertToRests(Collection<Attribute> models) {
        Collection<AttributeRest> rests = new HashSet<>(models.size());
        for (Attribute model : models) {
            rests.add((AttributeRest) converter.convertToRest(model));
        }
        return rests;
    }

}
