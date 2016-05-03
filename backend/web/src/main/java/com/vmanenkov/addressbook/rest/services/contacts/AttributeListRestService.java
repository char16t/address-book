package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.AttributeListRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.AttributeListService;
import com.vmanenkov.services.exceptions.AttributeListNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListNotValidException;
import java.util.Collection;
import java.util.HashSet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.cache.NoCache;

@Path("/attribute_lists")
@RequestScoped
@Profiled
public class AttributeListRestService {
    @Inject
    private LoggerAB log;
    
    @Inject
    private AttributeListService attributeListService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public AttributeListRest createAttributeList(AttributeListRest rest) throws AttributeListNotValidException {
        log.fine("createAttributeList(AttributeListRest rest = {0})", rest);
        AttributeList attributeList = attributeListService.create(rest.getName(), rest.getDescription());
        AttributeListRest attributeListRest = (AttributeListRest) converter.convertToRest(attributeList);
        return attributeListRest;
    }
    
    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity readAttributeList(@PathParam("id") Long id) throws AttributeListNotFoundException {
        log.fine("readAttributeList(@PathParam(\"id\") Long id = {0})", id);
        AttributeList attributeList = attributeListService.getById(id);
        return converter.convertToRest(attributeList);
    }
    
    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateAttributeList(
            AttributeListRest rest,
            @PathParam("id") Long id
    ) throws AttributeListNotValidException, AttributeListNotFoundException {
        log.fine("updateAttributeList(\n" +
                         "            AttributeListRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1}\n" +
                         "    )", rest, id);
        AttributeList attributeList = attributeListService.update(id, rest.getName(), rest.getDescription());
        return converter.convertToRest(attributeList);
    }
    
    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAttributeList(@PathParam("id") Long id) throws AttributeListNotFoundException {
        log.fine("deleteAttributeList(@PathParam(\"id\") Long id = {0})", id);
        attributeListService.delete(id);
    }
    
    @GET
    @NoCache
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<AttributeListRest> getAll() {
        Collection<AttributeList> attrLists = attributeListService.getAll();
        return convertToRests(attrLists);
    }

    private Collection<AttributeListRest> convertToRests(Collection<AttributeList> models) {
        Collection<AttributeListRest> rests = new HashSet<>(models.size());
        for (AttributeList model : models) {
            rests.add((AttributeListRest) converter.convertToRest(model));
        }
        return rests;
    }

}
