package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.RestEntity;

public class AttributeListRest implements RestEntity {
    private Long id;
    private String name;
    private String description;

    public AttributeListRest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "AttributeListRest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    
}
