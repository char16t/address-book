package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.rest.model.contacts.NoteRest;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.NoteService;
import com.vmanenkov.services.exceptions.NoteNotFoundException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/notes")
@RequestScoped
@Profiled
public class NoteRestService {

    @Inject
    private NoteService noteService;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoteRest createNote() {
        return null;
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoteRest readNote(@PathParam("id") Long id) {
        return null;
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoteRest updateNote(@PathParam("id") Long id) {
        return null;
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteNote(@PathParam("id") Long id) throws NoteNotFoundException {
        noteService.delete(id);
    }
}
