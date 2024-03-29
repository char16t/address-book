package com.vmanenkov.addressbook.rest.model.account;

import com.vmanenkov.addressbook.rest.model.RestEntity;

import java.util.Set;

public class AccountRest implements RestEntity {
    private Long id;
    private String email;
    private String password;
    private Set<RoleRest> roles;

    public AccountRest() {
    }

    public AccountRest(Long id, String email, String password, Set<RoleRest> roles) {
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

    @Override
    public String toString() {
        return "AccountRest{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
