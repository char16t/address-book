package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.RestEntity;

public class FieldTypeRest implements RestEntity {
    private Long id;
    private String typeName;

    public FieldTypeRest() {
    }

    public FieldTypeRest(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
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

    @Override
    public String toString() {
        return "FieldTypeRest{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
