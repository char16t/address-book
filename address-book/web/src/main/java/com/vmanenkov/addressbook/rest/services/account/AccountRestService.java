package com.vmanenkov.addressbook.rest.services.account;

import com.vmanenkov.addressbook.model.DbEntity;
import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.account.AccountRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.account.AccountService;
import com.vmanenkov.services.account.RoleService;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.exceptions.AccountNotFoundException;
import com.vmanenkov.services.exceptions.AccountNotValidException;
import com.vmanenkov.services.exceptions.EmailNotValidException;
import com.vmanenkov.services.exceptions.UserRoleNotFoundException;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Path("/accounts")
@RequestScoped
@Profiled
public class AccountRestService {

    @Inject
    private LoggerAB log;

    @Inject
    private AccountService accountService;

    @Inject
    private RoleService roleService;

    @Inject
    private EntityConverter converter;

    @POST
    @NoCache
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity createAccount(AccountRest rest)
            throws AccountNotValidException, EmailNotValidException {
        log.fine("createAccount(AccountRest rest = {0})", rest);
        Account account = accountService.create(rest.getEmail(), rest.getPassword());
        return converter.convertToRest(account);
    }

    @GET
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readAccount(@PathParam("id") Long id)
            throws AccountNotFoundException {
        log.fine("readAccount(@PathParam(\"id\") Long id = {0})", id);
        return converter.convertToRest(accountService.getById(id));
    }

    @GET
    @NoCache
    @Path("/{id}/info")
    @Produces(MediaType.APPLICATION_JSON)
    public RestEntity readAccountInfo(@PathParam("id") Long id)
            throws AccountNotFoundException {
        log.fine("readAccount(@PathParam(\"id\") Long id = {0})", id);
        Account account = accountService.getById(id);
        Person person = account.getPerson();
        return converter.convertToRest(person);
    }

    @PUT
    @NoCache
    @Path("/{id}/update_email")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity updateEmail(@PathParam("id") Long id,
                                  @QueryParam("email") String email)
            throws AccountNotValidException, AccountNotFoundException, EmailNotValidException {

        log.fine("updateEmail(@PathParam(\"id\") Long id = {0},\n" +
                 "            @QueryParam(\"email\") String email = {1})", id, email);
        return converter.convertToRest(accountService.updateEmail(id, email));
    }

    @PUT
    @NoCache
    @Path("/{id}/add_role")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity addRole(@PathParam("id") Long id,
                              @QueryParam("role_id") Long roleId)
            throws AccountNotFoundException, AccountNotValidException, UserRoleNotFoundException {

        log.fine("addRole(@PathParam(\"id\") Long id = {0},\n" +
                         "        @QueryParam(\"role_id\") Long roleId = {1})", id, roleId);
        Role role = roleService.getById(roleId);
        return converter.convertToRest(accountService.addRole(id, role));
    }

    @PUT
    @NoCache
    @Path("/{id}/remove_role")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public RestEntity removeRole(@PathParam("id") Long id,
                                 @QueryParam("role_id") Long roleId)
            throws AccountNotFoundException, AccountNotValidException, UserRoleNotFoundException {

        log.fine("removeRole(@PathParam(\"id\") Long id = {0},\n" +
                         "           @QueryParam(\"role_id\") Long roleId = {1})", id, roleId);
        Role role = roleService.getById(roleId);
        return converter.convertToRest(accountService.removeRole(id, role));
    }

    @DELETE
    @NoCache
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public void deleteAccount(@PathParam("id") Long id) throws AccountNotFoundException {
        log.fine("deleteAccount(@PathParam(\"id\") Long id = {0})", id);
        accountService.delete(id);
    }

    @GET
    @NoCache
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AccountRest> getAllAccount() {
        log.fine("getAllAttributeGroup()");
        return convertToRests(accountService.getAll());
    }

    @GET
    @NoCache
    @Path("/getAllByRole/")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AccountRest> getAllByRole(@QueryParam("role") String role) throws UserRoleNotFoundException {
        log.fine("getAllByRole(@QueryParam(\"role\") String role = {0})", role);
        Role roleObject = roleService.getByName(role);
        return convertToRests(accountService.getAccountsByRole(roleObject));
    }

    private Collection<AccountRest> convertToRests(Collection<Account> accounts) {
        Set<AccountRest> accountRests = new HashSet<>(accounts.size());
        for (DbEntity user : accounts) {
            accountRests.add((AccountRest) converter.convertToRest(user));
        }
        return accountRests;
    }

}
