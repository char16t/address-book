package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.NoteRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.addressbook.utils.EntityConverterImpl;
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
import java.util.Collection;
import java.util.HashSet;

@Path("/notes")
@RequestScoped
@Profiled
public class NoteRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private NoteService noteService;

    @Inject
    private PersonService personService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createNote(
            NoteRest rest,
            @QueryParam("person_id") Long personId
    ) throws NoteNotValidException, PersonNotFoundException {
        log.fine("createNote(\n" +
                         "            NoteRest rest = {0}, \n" +
                         "            @QueryParam(\"person_id\") Long personId = {1}\n" +
                         "    )", rest, personId);
        Person person = personService.get(personId);
        Note note = noteService.create(rest.getDate(), rest.getValue(), person);
        return converter.convertToRest(note);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity readNote(@PathParam("id") Long id) throws NoteNotFoundException {
        log.fine("readNote(@PathParam(\"id\") Long id = {0})", id);
        Note note = noteService.get(id);
        return converter.convertToRest(note);
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateNote(
            NoteRest rest,
            @QueryParam("person_id") Long personId,
            @PathParam("id") Long id
    ) throws PersonNotFoundException, NoteNotValidException, NoteNotFoundException {
        log.fine("updateNote(\n" +
                         "            NoteRest rest = {0}, \n" +
                         "            @QueryParam(\"person_id\") Long personId = {1}, \n" +
                         "            @PathParam(\"id\") Long id = {2}\n" +
                         "    )", rest, personId, id);
        Person person = personService.get(personId);
        Note note = noteService.update(id, rest.getDate(), rest.getValue(), person);
        return converter.convertToRest(note);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteNote(@PathParam("id") Long id) throws NoteNotFoundException {
        log.fine("deleteNote(@PathParam(\"id\") Long id = {0})", id);
        noteService.delete(id);
    }

    @GET
    @NoCache
    @Path("/get_by_person")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<NoteRest> getNotesByPerson(@QueryParam("person_id") Long personId) {
        Collection<Note> notes = noteService.getByPersonId(personId);
        return convertToRests(notes);
    }

    private Collection<NoteRest> convertToRests(Collection<Note> models) {
        Collection<NoteRest> rests = new HashSet<>(models.size());
        for (Note model : models) {
            rests.add((NoteRest) converter.convertToRest(model));
        }
        return rests;
    }
}
