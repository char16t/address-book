package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.RestEntity;

public class AttributeRest implements RestEntity {
    private Long id;
    private String name;
    private String description;
    private AttributeGroupRest attributeGroup;
    private AttributeTypeRest attributeType;
    private AttributeListRest attributeList;

    public AttributeRest() {
    }

    public AttributeRest(Long id, String name, String description, AttributeGroupRest attributeGroup, AttributeTypeRest attributeType, AttributeListRest attributeList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attributeGroup = attributeGroup;
        this.attributeType = attributeType;
        this.attributeList = attributeList;
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

    public AttributeGroupRest getAttributeGroup() {
        return attributeGroup;
    }

    public void setAttributeGroup(AttributeGroupRest attributeGroup) {
        this.attributeGroup = attributeGroup;
    }

    public AttributeTypeRest getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeTypeRest attributeType) {
        this.attributeType = attributeType;
    }

    public AttributeListRest getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(AttributeListRest attributeList) {
        this.attributeList = attributeList;
    }

    @Override
    public String toString() {
        return "AttributeRest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", attributeGroup=" + attributeGroup +
                ", attributeType=" + attributeType +
                ", attributeList=" + attributeList +
                '}';
    }
}
