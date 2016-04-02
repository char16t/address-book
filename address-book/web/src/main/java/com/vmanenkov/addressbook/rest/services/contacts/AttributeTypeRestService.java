package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeTypeService;
import com.vmanenkov.services.exceptions.AttributeTypeNotFoundException;
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

    @POST
    @NoCache
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public void createAttributeType() {

    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void readAttributeType(@PathParam("id") Long id) {

    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateAttributeType(@PathParam("id") Long id) {

    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAttributeType(@PathParam("id") Long id) throws AttributeTypeNotFoundException {
        attributeTypeService.delete(id);
    }
}
