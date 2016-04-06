package com.vmanenkov.addressbook.rest.model.contacts;

public class AttributeTypeRest {
    private Long id;
    private String name;
    private FieldTypeRest fieldType;

// todo: add other fields

    public AttributeTypeRest() {
    }

    public AttributeTypeRest(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public FieldTypeRest getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldTypeRest fieldType) {
        this.fieldType = fieldType;
    }
}
