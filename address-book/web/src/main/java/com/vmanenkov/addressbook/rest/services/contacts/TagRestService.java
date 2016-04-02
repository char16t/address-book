package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.TagService;
import com.vmanenkov.services.exceptions.TagNotFoundException;
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
    public void createTag() {

    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void readTag(@PathParam("id") Long id) {

    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateTag(@PathParam("id") Long id) {

    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteTag(@PathParam("id") Long id) throws TagNotFoundException {
        tagService.delete(id);
    }
}
