package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;
import java.util.Set;

// TODO: test onetomany relation
@Entity
@Table(name = "attribute_type")
public class AttributeType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private Set<Attribute> attributes;

    @ManyToOne
    @JoinColumn(name="field_type_id")
    private FieldType fieldType;

    public AttributeType() {
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

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
}
