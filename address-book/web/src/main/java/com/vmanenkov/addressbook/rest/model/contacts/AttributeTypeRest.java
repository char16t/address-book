package com.vmanenkov.addressbook.rest.model.contacts;

public class AttributeTypeRest {
    private Long id;
    private String name;
    private FieldTypeRest fieldType;

    public AttributeTypeRest() {
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
