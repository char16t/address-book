package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeValueRest;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeValueService;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeValueNotValidException;
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
    public AttributeValueRest createAttributeValue(AttributeValueRest rest) throws AttributeValueNotValidException {
        return convertToRest(attributeValueService.create(rest.getTextValue(), rest.getBlobValue()));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeValueRest readAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        return convertToRest(attributeValueService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeValueRest updateAttributeValue(@PathParam("id") Long id, AttributeValueRest rest) throws AttributeValueNotValidException, AttributeValueNotFoundException {
        return convertToRest(attributeValueService.update(id, rest.getTextValue(), rest.getBlobValue()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        attributeValueService.delete(id);
    }

    private AttributeValueRest convertToRest(AttributeValue attributeValue) {
        return new AttributeValueRest(
            attributeValue.getId(),
            attributeValue.getTextValue(),
            attributeValue.getBlobValue()
        );
    }
}
