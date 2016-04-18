package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.PersonRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.account.AccountService;
import com.vmanenkov.services.contacts.AttributeValueService;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.contacts.TagService;
import com.vmanenkov.services.exceptions.AccountNotFoundException;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
import com.vmanenkov.services.exceptions.PersonNotValidException;
import com.vmanenkov.services.exceptions.TagNotFoundException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashSet;

@Path("/contacts")
@RequestScoped
@Profiled
public class PersonRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private PersonService personService;

    @Inject
    private AccountService accountService;

    @Inject
    private TagService tagService;

    @Inject
    private AttributeValueService attributeValueService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createPerson(PersonRest rest) throws PersonNotValidException {
        log.fine("createPerson(PersonRest rest = {0})", rest);
        Person person = personService.create(rest.getFirstName(), rest.getLastName(), rest.getDescription());
        return converter.convertToRest(person);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readPerson(@PathParam("id") Long id) throws PersonNotFoundException {
        log.fine("readPerson(@PathParam(\"id\") Long id = {0})", id);
        Person person = personService.get(id);
        return converter.convertToRest(person);
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updatePerson(
            PersonRest rest,
            @PathParam("id") Long id
    ) throws PersonNotValidException, PersonNotFoundException {
        log.fine("updatePerson(\n" +
                         "            PersonRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1}\n" +
                         "    )", rest, id);
        Person person = personService.update(id, rest.getFirstName(), rest.getLastName(), rest.getDescription());
        return converter.convertToRest(person);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deletePerson(@PathParam("id") Long id) throws PersonNotFoundException {
        log.fine("deletePerson(@PathParam(\"id\") Long id = {0})", id);
        personService.delete(id);
    }

    @GET
    @NoCache
    @Path("/get_all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<PersonRest> getPersonsByAccount(@QueryParam("account_id") Long accountId) {
        Collection<Person> persons = personService.getByAccountId(accountId);
        return convertToRests(persons);
    }

    @GET
    @NoCache
    @Path("/get_by_tag")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<PersonRest> getPersonsByTag(
            @QueryParam("account_id") Long accountId,
            @QueryParam("tag_id") Long tagId) throws AccountNotFoundException, TagNotFoundException {

        Account account = accountService.getById(accountId);
        Tag tag = tagService.get(tagId);

        Collection<Person> persons = personService.getByAccountAndTag(account, tag);
        return convertToRests(persons);
    }

    @GET
    @NoCache
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<PersonRest> getPersonsByQuery(
            @QueryParam("account_id") Long accountId,
            @QueryParam("query") String query) throws AccountNotFoundException {

        Account account = accountService.getById(accountId);
        Collection<Person> persons = personService.getByAllFields(account, query);
        return convertToRests(persons);
    }


    private Collection<PersonRest> convertToRests(Collection<Person> models) {
        Collection<PersonRest> rests = new HashSet<>(models.size());
        for (Person model : models) {
            rests.add((PersonRest) converter.convertToRest(model));
        }
        return rests;
    }
}