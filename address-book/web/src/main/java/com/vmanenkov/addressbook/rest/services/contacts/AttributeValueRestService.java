package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeValue;
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
    @Produces(MediaType.APPLICATION_JSON)
    public void createAttributeValue() {

    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void readAttributeValue(@PathParam("id") Long id) {

    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateAttributeValue(@PathParam("id") Long id) {

    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        attributeValueService.delete(id);
    }
}
