package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.addressbook.rest.model.contacts.TagRest;
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
    private TagService tagService;

    @POST
    @NoCache
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public TagRest createTag(TagRest rest) throws TagNotValidException {
        return convertToRest(tagService.create(rest.getName(), rest.getDescription()));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TagRest readTag(@PathParam("id") Long id) throws TagNotFoundException {
        return convertToRest(tagService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TagRest updateTag(@PathParam("id") Long id, TagRest rest) throws TagNotValidException, TagNotFoundException {
        return convertToRest(tagService.update(id, rest.getName(), rest.getDescription()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteTag(@PathParam("id") Long id) throws TagNotFoundException {
        tagService.delete(id);
    }

    private TagRest convertToRest(Tag tag) {
        return new TagRest(
                tag.getId(),
                tag.getName(),
                tag.getDescription()
        );
    }
}
