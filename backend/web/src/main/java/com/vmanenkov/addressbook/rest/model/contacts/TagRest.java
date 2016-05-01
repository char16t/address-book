package com.vmanenkov.addressbook.rest.model.contacts;


import com.vmanenkov.addressbook.rest.model.RestEntity;

public class TagRest implements RestEntity {
    private Long id;
    private String name;
    private Boolean publicTag;
    private String description;

    public TagRest() {
    }

    public TagRest(Long id, String name, Boolean publicTag, String description) {
        this.id = id;
        this.name = name;
        this.publicTag = publicTag;
        this.description = description;
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

    public Boolean isPublicTag() {
        return publicTag;
    }

    public void setPublicTag(Boolean publicTag) {
        this.publicTag = publicTag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TagRest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicTag='" + publicTag + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
