package com.vmanenkov.addressbook.rest.model.contacts;

public class FieldTypeRest {
    private Long id;
    private String typeName;

    public FieldTypeRest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
