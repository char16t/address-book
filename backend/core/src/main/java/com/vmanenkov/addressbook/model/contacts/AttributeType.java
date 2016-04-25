package com.vmanenkov.addressbook.model.contacts;

import com.vmanenkov.addressbook.model.DbEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attribute_type")
public class AttributeType implements DbEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "attributeType")
    private Set<Attribute> attributes;

    @ManyToOne
    @JoinColumn(name="field_type_id")
    private FieldType fieldType;

    // todo: add other fields
    @Column(name="regex", length=1024)
    private String regex;
    
    @Column(name="required")
    private Boolean required;
    
    @Column(name="hidden")
    private Boolean hidden;
    
    @Column(name="description", length=1024)
    private String description;
    
    
    public AttributeType() {
    }

    public AttributeType(String name, FieldType fieldType) {
        this.name = name;
        this.fieldType = fieldType;
    }

    public AttributeType(String name, Set<Attribute> attributes, FieldType fieldType) {
        this.name = name;
        this.attributes = attributes;
        this.fieldType = fieldType;
    }

    public AttributeType(String name, String regex, Boolean required, Boolean hidden, String description, FieldType fieldType) {
        this.name = name;
        this.regex = regex;
        this.required = required;
        this.hidden = hidden;
        this.description = description;
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
    
    
}
