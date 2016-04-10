package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.rest.model.contacts.PersonRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.addressbook.utils.EntityConverterImpl;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
import com.vmanenkov.services.exceptions.PersonNotValidException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/contacts")
@RequestScoped
@Profiled
public class PersonRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private PersonService personService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonRest createPerson(PersonRest rest) throws PersonNotValidException {
        log.fine("createPerson(PersonRest rest = {0})", rest);
        Person person = personService.create(rest.getFirstName(), rest.getLastName(), rest.getDescription());
        return (PersonRest) converter.convertToRest(person);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonRest readPerson(@PathParam("id") Long id) throws PersonNotFoundException {
        log.fine("readPerson(@PathParam(\"id\") Long id = {0})", id);
        Person person = personService.get(id);
        return (PersonRest) converter.convertToRest(person);
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonRest updatePerson(
            PersonRest rest,
            @PathParam("id") Long id
    ) throws PersonNotValidException, PersonNotFoundException {
        log.fine("updatePerson(\n" +
                         "            PersonRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1}\n" +
                         "    )", rest, id);
        Person person = personService.update(id, rest.getFirstName(), rest.getLastName(), rest.getDescription());
        return (PersonRest) converter.convertToRest(person);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deletePerson(@PathParam("id") Long id) throws PersonNotFoundException {
        log.fine("deletePerson(@PathParam(\"id\") Long id = {0})", id);
        personService.delete(id);
    }

    // TODO: Remove this
    private PersonRest convertToRest(Person person) {
        return new PersonRest(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getDescription()
        );
    }
}
