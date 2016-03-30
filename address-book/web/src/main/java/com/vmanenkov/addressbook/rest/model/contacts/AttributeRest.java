package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeValue;

public class AttributeRest {
    private Long id;
    private String name;
    private String description;
    private AttributeGroupRest attributeGroup;
    private AttributeTypeRest attributeType;
    private AttributeValue attributeValue;

    public AttributeRest() {
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

    public AttributeValue getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
    }
}
