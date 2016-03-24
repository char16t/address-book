package com.vmanenkov.addressbook.rest.model.user;

import com.vmanenkov.addressbook.model.user.Role;

import java.util.Set;

public class UserRest {
    private Long id;
    private String email;
    private String password;
    private Set<RoleRest> roles;

    public UserRest() {
    }

    public UserRest(Long id, String email, String password, Set<RoleRest> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleRest> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleRest> roles) {
        this.roles = roles;
    }
}
