package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeGroupRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeGroupService;
import com.vmanenkov.services.exceptions.AttributeGroupNotFoundException;
import com.vmanenkov.services.exceptions.AttributeGroupNotValidException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashSet;

@Path("/attribute_groups")
@RequestScoped
@Profiled
public class AttributeGroupRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private AttributeGroupService attributeGroupService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createAttributeGroup(AttributeGroupRest rest)
            throws AttributeGroupNotValidException {
        log.fine("createAttributeGroup(AttributeGroupRest rest = {0})", rest);
        AttributeGroup group = attributeGroupService.create(rest.getName(), rest.getDescription());
        return converter.convertToRest(group);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readAttributeGroup(@PathParam("id") Long id)
            throws AttributeGroupNotFoundException {
        log.fine("readAttributeGroup(@PathParam(\"id\") Long id = {0})", id);
        return converter.convertToRest(attributeGroupService.get(id));
    }

    @GET
    @NoCache
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AttributeGroupRest> getAllAttributeGroup() {
        log.fine("getAllAttributeGroup()");
        return convertToRests(attributeGroupService.getAll());
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity updateAttributeGroup(@PathParam("id") Long id,
                                           AttributeGroupRest rest)
            throws AttributeGroupNotFoundException, AttributeGroupNotValidException {
        log.fine("updateAttributeGroup(@PathParam(\"id\") Long id = {0}, AttributeGroupRest rest = {1})", id, rest);
        return converter.convertToRest(attributeGroupService.update(id, rest.getName(), rest.getDescription()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAttributeGroup(@PathParam("id") Long id) throws AttributeGroupNotFoundException {
        log.fine("deleteAttributeGroup(@PathParam(\"id\") Long id = {0})", id);
        attributeGroupService.delete(id);
    }

    private Collection<AttributeGroupRest> convertToRests(Collection<AttributeGroup> models) {
        Collection<AttributeGroupRest> rests = new HashSet<>(models.size());
        for (AttributeGroup model : models) {
            rests.add((AttributeGroupRest) converter.convertToRest(model));
        }
        return rests;
    }
}
