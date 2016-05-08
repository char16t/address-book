package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.addressbook.model.contacts.AttributeListValue;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeListValueRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeListService;
import com.vmanenkov.services.contacts.AttributeListValueService;
import com.vmanenkov.services.exceptions.AttributeListNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListValueNotValidException;
import java.util.Collection;
import java.util.HashSet;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.cache.NoCache;

@Path("/attribute_lists_values")
@RequestScoped
@Profiled
public class AttributeListValueRestService {
    @Inject
    private LoggerAB log;
    
    @Inject
    private AttributeListValueService attributeListValueService;
    
    @Inject
    private AttributeListService attributeListService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createAttributeListValue(
            AttributeListValueRest rest,
            @QueryParam("list_id") Long listId
    ) throws AttributeListValueNotValidException, AttributeListValueNotFoundException, AttributeListNotFoundException {

        log.fine("createAttributeListValue(\n" +
                         "            AttributeListValueRest rest = {0},\n" +
                         "            @QueryParam(\"list_id\") Long listId = {1},\n" +
                         "    )", rest, listId);
        AttributeList attributeList = attributeListService.getById(listId);
        AttributeListValue value = attributeListValueService.create(attributeList, rest.getValue() );
        return converter.convertToRest(value);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readAttributeValue(@PathParam("id") Long id) throws AttributeListValueNotFoundException {
        log.fine("readAttributeListValue(@PathParam(\"id\") Long id = {0})", id);
        return converter.convertToRest(attributeListValueService.getById(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateAttributeListValue(@PathParam("id") Long id, 
            @QueryParam("list_id") Long listId, AttributeListValueRest rest
    ) throws AttributeListValueNotValidException, AttributeListValueNotFoundException {
        log.fine("updateAttributeListValue(@PathParam(\"id\") Long id = {0}, @QueryParam(\"list_id\") Long listId = {1}, AttributeValueRest rest = {2})", id, listId, rest);
        AttributeListValue value = attributeListValueService.update(id, rest.getValue());
        return converter.convertToRest(value);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAttributeListValue(@PathParam("id") Long id) throws AttributeListValueNotFoundException {
        log.fine("deleteAttributeListValue(@PathParam(\"id\") Long id = {0})", id);
        attributeListValueService.delete(id);
    }
    
    @GET
    @NoCache
    @Path("/get_all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<AttributeListValueRest> getAllAttributeListValueByListId(@QueryParam("list_id") Long listId) throws  AttributeListNotFoundException{
        Collection<AttributeListValue> attrLists = attributeListValueService.getAllByListId(listId);
        return convertToRests(attrLists);
    }

    private Collection<AttributeListValueRest> convertToRests(Collection<AttributeListValue> models) {
        Collection<AttributeListValueRest> rests = new HashSet<>(models.size());
        for (AttributeListValue model : models) {
            rests.add((AttributeListValueRest) converter.convertToRest(model));
        }
        return rests;
    }

}
