package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeListValue;
import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeValueRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeListValueService;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.contacts.AttributeValueService;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.exceptions.AttributeListValueNotFoundException;
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

    @Inject
    private AttributeListValueService attributeListValueService;
    
    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createAttributeValue(
            AttributeValueRest rest,
            @QueryParam("person_id") Long personId,
            @QueryParam("attribute_id") Long attributeId,
            @QueryParam("list_value_id") Long listValueId
    ) throws AttributeValueNotValidException, PersonNotFoundException, AttributeNotFoundException, AttributeListValueNotFoundException {

        log.fine("createAttributeValue(\n" +
                         "            AttributeValueRest rest = {0},\n" +
                         "            @QueryParam(\"person_id\") Long personId = {1},\n" +
                         "            @QueryParam(\"attribute_id\") Long attributeId = {2}\n" +
                         "            @QueryParam(\"list_value_id\") Long listValueId = {3}\n" +
                         "    )", rest, personId, attributeId, listValueId);
        Person person = personService.get(personId);
        Attribute attribute = attributeService.get(attributeId);
        AttributeListValue attributeListValue = null;
        if (listValueId != null) {
            attributeListValue= attributeListValueService.getById(listValueId);
        }
        AttributeValue value = attributeValueService.create(rest.getTextValue(), rest.getBlobValue(),
                                                            person, attribute, attributeListValue);
        return converter.convertToRest(value);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        log.fine("readAttributeValue(@PathParam(\"id\") Long id = {0})", id);
        return converter.convertToRest(attributeValueService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateAttributeValue(@PathParam("id") Long id, AttributeValueRest rest,
            @QueryParam("list_value_id") Long listValueId) throws AttributeValueNotValidException, AttributeValueNotFoundException, AttributeListValueNotFoundException {
        log.fine("updateAttributeValue(@PathParam(\"id\") Long id = {0}, AttributeValueRest rest = {1}, Long listValueId={2})", id, rest, listValueId);
        AttributeListValue attributeListValue = null;
        if (listValueId != null) {
            attributeListValue= attributeListValueService.getById(listValueId);
        }
        AttributeValue value = attributeValueService.update(id, rest.getTextValue(), rest.getBlobValue(), attributeListValue);
        return converter.convertToRest(value);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAttributeValue(@PathParam("id") Long id) throws AttributeValueNotFoundException {
        log.fine("deleteAttributeValue(@PathParam(\"id\") Long id = {0})", id);
        attributeValueService.delete(id);
    }
}
