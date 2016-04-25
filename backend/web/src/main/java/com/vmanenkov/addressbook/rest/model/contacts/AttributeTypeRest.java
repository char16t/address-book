package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.RestEntity;

public class AttributeTypeRest implements RestEntity {
    private Long id;
    private String name;
    private String regex;
    private Boolean required;
    private Boolean hidden;
    private String description;
    private FieldTypeRest fieldType;
    

// todo: add other fields

    public AttributeTypeRest() {
    }

    public AttributeTypeRest(Long id, String name, FieldTypeRest fieldType) {
        this.id = id;
        this.name = name;
        this.fieldType = fieldType;
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

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Boolean isRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Boolean isHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public FieldTypeRest getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldTypeRest fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public String toString() {
        return "AttributeTypeRest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fieldType=" + fieldType +
                '}';
    }
}
