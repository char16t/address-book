package com.vmanenkov.addressbook.rest.services.user;

import com.vmanenkov.addressbook.model.user.Role;
import com.vmanenkov.addressbook.model.user.User;
import com.vmanenkov.addressbook.rest.model.user.RoleRest;
import com.vmanenkov.addressbook.rest.model.user.UserRest;
import com.vmanenkov.profile.Profiled;
import com.vmanenkov.services.exceptions.UserRoleNotFoundException;
import com.vmanenkov.services.user.RoleService;
import com.vmanenkov.services.user.UserService;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;

@Path("/users")
@RequestScoped
@Profiled
public class UserRestService {
    @Inject
    private UserService userService;

    @Inject
    private RoleService roleService;

    @GET
    @NoCache
    @Path("/getAllByRole/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<UserRest> getAllByRole(@PathParam("role") String role) throws UserRoleNotFoundException {
        Role roleObject = roleService.getByName(role);
        return convertUsersToRests(userService.getUsersByRole(roleObject));
    }

    private Set<RoleRest> convertRolesToRests(Set<Role> roles) {
        Set<RoleRest> roleRests = new HashSet<>(roles.size());
        for (Role role : roles) {
            roleRests.add(new RoleRest(role.getName()));
        }
        return roleRests;
    }

    private Set<UserRest> convertUsersToRests(Set<User> users) {
        Set<UserRest> userRests = new HashSet<>(users.size());
        for (User user : users) {
            userRests.add(convertToRest(user));
        }
        return userRests;
    }

    private UserRest convertToRest(User model) {
        if (model != null) {
            return new UserRest(model.getId(), model.getEmail(), model.getPassword(), convertRolesToRests(model.getRoles()));
        }
        else {
            return null;
        }
    }
}
