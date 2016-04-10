package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeGroupRest;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeRest;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeTypeRest;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeValueRest;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.contacts.AttributeValueService;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.exceptions.AttributeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeValueNotValidException;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
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
    private LoggerAB log;

    @Inject
    private AttributeValueService attributeValueService;

    @Inject
    private AttributeService attributeService;

    @Inject
    private PersonService personService;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeValueRest createAttributeValue(
            AttributeValueRest rest,
            @QueryParam("person_id") Long personId,
            @QueryParam("attribute_id") Long attributeId
    ) throws AttributeValueNotValidException, PersonNotFoundException, AttributeNotFoundException {

        log.fine("createAttributeValue(\n" +
                         "            AttributeValueRest rest = {0},\n" +
                         "            @QueryParam(\"person_id\") Long personId = {1},\n" +
                         "            @QueryParam(\"attribute_id\") Long attributeId = {2}\n" +
                         "    )", rest, personId, attributeId);
        Person person = personService.get(personId);
        Attribute attribute = attributeService.get(attributeId);

        return convertToRest(attributeValueService.create(rest.getTextValue(), rest.getBlobValue(), person, attribute));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AttributeValueRest readAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        log.fine("readAttributeValue(@PathParam(\"id\") Long id = {0})", id);
        return convertToRest(attributeValueService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeValueRest updateAttributeValue(@PathParam("id") Long id, AttributeValueRest rest) throws AttributeValueNotValidException, AttributeValueNotFoundException {
        log.fine("updateAttributeValue(@PathParam(\"id\") Long id = {0}, AttributeValueRest rest = {1})", id, rest);
        return convertToRest(attributeValueService.update(id, rest.getTextValue(), rest.getBlobValue()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        log.fine("deleteAttributeValue(@PathParam(\"id\") Long id = {0})", id);
        attributeValueService.delete(id);
    }

    private AttributeValueRest convertToRest(AttributeValue attributeValue) {

        Attribute attribute = attributeValue.getAttribute();
        // todo: to VM - this isn't beautiful
        return new AttributeValueRest(
                attributeValue.getId(),
                attributeValue.getTextValue(),
                attributeValue.getBlobValue(),
                new AttributeRest(attribute.getId(), attribute.getName(), attribute.getDescription(),
                                  new AttributeGroupRest(attribute.getAttributeGroup().getId(),
                                                         attribute.getAttributeGroup().getName(),
                                                         attribute.getAttributeGroup().getDescription()),
                                  new AttributeTypeRest(attribute.getAttributeType().getId(),
                                                        attribute.getAttributeType().getName())
                )
        );
    }
}
