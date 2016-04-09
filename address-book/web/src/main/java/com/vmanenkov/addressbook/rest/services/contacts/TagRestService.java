package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.addressbook.rest.model.contacts.TagRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.addressbook.utils.EntityConverterImpl;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.TagService;
import com.vmanenkov.services.exceptions.TagNotFoundException;
import com.vmanenkov.services.exceptions.TagNotValidException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/tags")
@RequestScoped
@Profiled
public class TagRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private TagService tagService;

    private EntityConverter converter = new EntityConverterImpl();

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public TagRest createTag(TagRest rest) throws TagNotValidException {
        log.fine("createTag(TagRest rest = {0})", rest);
        Tag tag = tagService.create(rest.getName(), rest.getDescription());
        TagRest tagRest = (TagRest) converter.convertToRest(tag);
        return tagRest;
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public TagRest readTag(@PathParam("id") Long id) throws TagNotFoundException {
        log.fine("readTag(@PathParam(\"id\") Long id = {0})", id);
        Tag tag = tagService.get(id);
        return (TagRest) converter.convertToRest(tag);
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public TagRest updateTag(
            TagRest rest,
            @PathParam("id") Long id
    ) throws TagNotValidException, TagNotFoundException {
        log.fine("updateTag(\n" +
                         "            TagRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1}\n" +
                         "    )", rest, id);
        Tag tag = tagService.update(id, rest.getName(), rest.getDescription());
        return (TagRest) converter.convertToRest(tag);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteTag(@PathParam("id") Long id) throws TagNotFoundException {
        log.fine("deleteTag(@PathParam(\"id\") Long id = {0})", id);
        tagService.delete(id);
    }

    // TODO: Remove this
    /*
    private TagRest convertToRest(Tag tag) {
        return new TagRest(
                tag.getId(),
                tag.getName(),
                tag.getDescription()
        );
    }
    */
}
