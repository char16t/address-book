package com.vmanenkov.addressbook.model.contacts;

import com.vmanenkov.addressbook.model.DbEntity;

import javax.persistence.*;
import java.util.Set;

// TODO: test OneToMany relations
@Entity
@Table(name = "field_type")
public class FieldType implements DbEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany
    private Set<AttributeType> attributeTypes;

    public FieldType() {
    }

    public FieldType(String typeName) {
        this.typeName = typeName;
    }

    public FieldType(String typeName, Set<AttributeType> attributeTypes) {
        this.typeName = typeName;
        this.attributeTypes = attributeTypes;
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

    public Set<AttributeType> getAttributeTypes() {
        return attributeTypes;
    }

    public void setAttributeTypes(Set<AttributeType> attributeTypes) {
        this.attributeTypes = attributeTypes;
    }
}
