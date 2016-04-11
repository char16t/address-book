package com.vmanenkov.addressbook.rest.model.account;


public class RoleRest {
    private Long id;
    private String name;

    public RoleRest() {
    }

    public RoleRest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoleRest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
