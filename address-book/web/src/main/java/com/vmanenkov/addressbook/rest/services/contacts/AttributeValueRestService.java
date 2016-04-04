package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.rest.model.contacts.AttributeValueRest;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeValueService;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/attribute_values")
@RequestScoped
@Profiled
public class AttributeValueRestService {

    @Inject
    private AttributeValueService attributeValueService;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeValueRest createAttributeValue() {
        return null;
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeValueRest readAttributeValue(@PathParam("id") Long id) {
        return null;
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeValueRest updateAttributeValue(@PathParam("id") Long id) {
        return null;
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        attributeValueService.delete(id);
    }
}
