package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.rest.model.contacts.NoteRest;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.NoteService;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.exceptions.NoteNotFoundException;
import com.vmanenkov.services.exceptions.NoteNotValidException;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
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

    @Inject
    private PersonService personService;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoteRest createNote(NoteRest rest, @QueryParam("person_id") Long personId) throws NoteNotValidException, PersonNotFoundException {
        Person person = personService.get(personId);
        return convertToRest(noteService.create(rest.getDate(), rest.getValue(), person));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoteRest readNote(@PathParam("id") Long id) throws NoteNotFoundException {
        return convertToRest(noteService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public NoteRest updateNote(NoteRest rest,@QueryParam("person_id") Long personId, @PathParam("id") Long id) throws PersonNotFoundException, NoteNotValidException, NoteNotFoundException {
        Person person = personService.get(personId);
        return convertToRest(noteService.update(id, rest.getDate(), rest.getValue(), person));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deleteNote(@PathParam("id") Long id) throws NoteNotFoundException {
        noteService.delete(id);
    }

    private NoteRest convertToRest(Note note) {
        return new NoteRest(
                note.getId(),
                note.getDate(),
                note.getValue(),
                note.getPerson()
        );
    }
}
