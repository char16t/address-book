package com.vmanenkov.addressbook.rest.model.account;


public class RoleRest {
    private String role;

    public RoleRest() {
    }

    public RoleRest(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
