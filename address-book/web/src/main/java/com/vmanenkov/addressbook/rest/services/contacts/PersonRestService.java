package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.rest.model.contacts.PersonRest;
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
    private PersonService personService;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonRest createPerson(PersonRest rest) throws PersonNotValidException {
        return convertToRest(personService.create(rest.getFirstName(), rest.getLastName(), rest.getDescription()));
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonRest readPerson(@PathParam("id") Long id) throws PersonNotFoundException {
        return convertToRest(personService.get(id));
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public PersonRest updatePerson(
            PersonRest rest,
            @PathParam("id") Long id)
            throws PersonNotValidException, PersonNotFoundException {
        return convertToRest(personService.update(id, rest.getFirstName(), rest.getLastName(), rest.getDescription()));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    public void deletePerson(@PathParam("id") Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

    private PersonRest convertToRest(Person person) {
        return new PersonRest(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getDescription()
        );
    }
}
