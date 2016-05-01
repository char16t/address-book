package com.vmanenkov.addressbook.rest.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.TagRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.account.AccountService;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.contacts.TagService;
import com.vmanenkov.services.exceptions.AccountNotFoundException;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
import com.vmanenkov.services.exceptions.TagNotFoundException;
import com.vmanenkov.services.exceptions.TagNotValidException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashSet;

@Path("/tags")
@RequestScoped
@Profiled
public class TagRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private TagService tagService;

    @Inject
    private AccountService accountService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public TagRest createTag(TagRest rest) throws TagNotValidException {
        log.fine("createTag(TagRest rest = {0})", rest);
        Tag tag = tagService.create(rest.getName(), rest.isPublicTag(), rest.getDescription());
        TagRest tagRest = (TagRest) converter.convertToRest(tag);
        return tagRest;
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity readTag(@PathParam("id") Long id) throws TagNotFoundException {
        log.fine("readTag(@PathParam(\"id\") Long id = {0})", id);
        Tag tag = tagService.get(id);
        return converter.convertToRest(tag);
    }

    @PUT
    @NoCache
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateTag(
            TagRest rest,
            @PathParam("id") Long id
    ) throws TagNotValidException, TagNotFoundException {
        log.fine("updateTag(\n" +
                         "            TagRest rest = {0},\n" +
                         "            @PathParam(\"id\") Long id = {1}\n" +
                         "    )", rest, id);
        Tag tag = tagService.update(id, rest.getName(), rest.isPublicTag(), rest.getDescription());
        return converter.convertToRest(tag);
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteTag(@PathParam("id") Long id) throws TagNotFoundException {
        log.fine("deleteTag(@PathParam(\"id\") Long id = {0})", id);
        tagService.delete(id);
    }

    @GET
    @NoCache
    @Path("/get_all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<TagRest> getTagsByAccount(@QueryParam("account_id") Long accountId) throws AccountNotFoundException {
        Collection<Tag> tags;
        Collection<Tag> publicTags = tagService.getAll();
        if (accountId == null) {
            //tags = tagService.getAll();
            tags = publicTags;
        }
        else {
            accountService.getById(accountId);  //зачем? ведь AccountNotFoundException и так бросается.
            tags = tagService.getByAccount(accountId);
            for (Tag tag: publicTags) {
                if (!tags.contains(tag)) {
                    tags.add(tag);
                }
            }
        }
        return convertToRests(tags);
    }

    @GET
    @NoCache
    @Path("/get_all_by_person")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<TagRest> getTagsByPerson(@QueryParam("person_id") Long personId) throws PersonNotFoundException {
        Collection<Tag> tags;
        if (personId == null) {
            tags = tagService.getAll();
        }
        else {
            //personService.getById(personId);
            tags = tagService.getByPerson(personId);
        }
        return convertToRests(tags);
    }
    
    private Collection<TagRest> convertToRests(Collection<Tag> models) {
        Collection<TagRest> rests = new HashSet<>(models.size());
        for (Tag model : models) {
            rests.add((TagRest) converter.convertToRest(model));
        }
        return rests;
    }
}
