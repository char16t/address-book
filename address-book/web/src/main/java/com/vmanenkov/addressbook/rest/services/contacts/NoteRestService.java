package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.profile.Profiled;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/notes")
@RequestScoped
@Profiled
public class NoteRestService {
    @POST
    @NoCache
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public void createNote() {

    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void readNote(@PathParam("id") Long id) {

    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateNote(@PathParam("id") Long id) {

    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteNote(@PathParam("id") Long id) {

    }
}
