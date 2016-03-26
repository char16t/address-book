package com.vmanenkov.addressbook.rest.services.test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vmanenkov.addressbook.rest.model.TestSimple;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.user.AccountService;
import com.vmanenkov.services.user.PermissionService;
import com.vmanenkov.services.user.RoleService;
import org.jboss.resteasy.annotations.cache.NoCache;

import java.util.Random;

@Path("/accounts")
@RequestScoped
@Profiled
public class AccountRestService {
    @Inject
    private AccountService accountService;

    @Inject
    private RoleService roleService;

    @Inject
    private PermissionService permissionService;

    @GET
    @NoCache
    @Path("/simple")
    @Produces(MediaType.APPLICATION_JSON)
    public TestSimple testSimple() {
        Random r = new Random();
        return new TestSimple(r.nextInt(), r.nextInt(), r.nextInt(), r.nextInt());
    }
}
