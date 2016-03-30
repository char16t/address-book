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
        return convert(attributeGroupService.create(rest.getName(), rest.getDescription()));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeGroupRest readAttributeGroup(@PathParam("id") Long id)
            throws AttributeGroupNotFoundException {
        return convert(attributeGroupService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeGroupRest updateAttributeGroup(@PathParam("id") Long id,
                                                   AttributeGroupRest rest)
            throws AttributeGroupNotFoundException, AttributeGroupNotValidException {
        return convert(attributeGroupService.update(id, rest.getName(), rest.getDescription()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAttributeGroup(@PathParam("id") Long id) throws AttributeGroupNotFoundException {
        attributeGroupService.delete(id);
    }

    private AttributeGroupRest convert(AttributeGroup attributeGroup) {
        return new AttributeGroupRest(attributeGroup.getId(),
                                      attributeGroup.getName(),
                                      attributeGroup.getDescription());
    }
}
