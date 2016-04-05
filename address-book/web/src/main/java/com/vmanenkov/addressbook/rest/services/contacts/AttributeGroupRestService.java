package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeGroupRest;
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
    private AttributeGroupService attributeGroupService;


    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeGroupRest createAttributeGroup(AttributeGroupRest rest)
            throws AttributeGroupNotValidException {
        return convertToRest(attributeGroupService.create(rest.getName(), rest.getDescription()));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeGroupRest readAttributeGroup(@PathParam("id") Long id)
            throws AttributeGroupNotFoundException {
        return convertToRest(attributeGroupService.get(id));
    }

    @GET
    @NoCache
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AttributeGroupRest> getAllAttributeGroup() {
        return convertToRests(attributeGroupService.getAll());
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeGroupRest updateAttributeGroup(@PathParam("id") Long id,
                                                   AttributeGroupRest rest)
            throws AttributeGroupNotFoundException, AttributeGroupNotValidException {
        return convertToRest(attributeGroupService.update(id, rest.getName(), rest.getDescription()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteAttributeGroup(@PathParam("id") Long id) throws AttributeGroupNotFoundException {
        attributeGroupService.delete(id);
    }

    private AttributeGroupRest convertToRest(AttributeGroup attributeGroup) {
        return new AttributeGroupRest(attributeGroup.getId(),
                                      attributeGroup.getName(),
                                      attributeGroup.getDescription());
    }

    private Collection<AttributeGroupRest> convertToRests(Collection<AttributeGroup> models) {
        Collection<AttributeGroupRest> rests = new HashSet<>(models.size());
        for (AttributeGroup model : models) {
            rests.add(convertToRest(model));
        }
        return rests;
    }
}
