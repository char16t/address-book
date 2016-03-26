package com.vmanenkov.addressbook.rest.services.account;

import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.addressbook.rest.model.user.RoleRest;
import com.vmanenkov.addressbook.rest.model.user.AccountRest;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.exceptions.UserRoleNotFoundException;
import com.vmanenkov.services.user.AccountService;
import com.vmanenkov.services.user.RoleService;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;

@Path("/accounts")
@RequestScoped
@Profiled
public class AccountRestService {
    @Inject
    private AccountService accountService;

    @Inject
    private RoleService roleService;

    @GET
    @NoCache
    @Path("/getAllByRole/")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<AccountRest> getAllByRole(@QueryParam("role") String role) throws UserRoleNotFoundException {
        Role roleObject = roleService.getByName(role);
        return convertUsersToRests(accountService.getAccountsByRole(roleObject));
    }

    private Set<RoleRest> convertRolesToRests(Set<Role> roles) {
        Set<RoleRest> roleRests = new HashSet<>(roles.size());
        for (Role role : roles) {
            roleRests.add(new RoleRest(role.getName()));
        }
        return roleRests;
    }

    private Set<AccountRest> convertUsersToRests(Set<Account> users) {
        Set<AccountRest> accountRests = new HashSet<>(users.size());
        for (Account user : users) {
            accountRests.add(convertToRest(user));
        }
        return accountRests;
    }

    private AccountRest convertToRest(Account model) {
        if (model != null) {
            return new AccountRest(model.getId(), model.getEmail(), model.getPassword(), convertRolesToRests(model.getRoles()));
        }
        else {
            return null;
        }
    }
}
