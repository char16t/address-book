package com.vmanenkov.addressbook.model.contacts;

import com.vmanenkov.addressbook.model.DbEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attribute")
public class Attribute implements DbEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "attribute")
    private Set<AttributeValue> attributeValues;

    @ManyToOne(optional = false)
    @JoinColumn(name="group_id")
    private AttributeGroup attributeGroup;

    @ManyToOne
    @JoinColumn(name="type_id")
    private AttributeType attributeType;

    public Attribute() {
    }

    public Attribute(String name, String description, Set<AttributeValue> attributeValues,
                     AttributeGroup attributeGroup, AttributeType attributeType) {
        this.name = name;
        this.description = description;
        this.attributeValues = attributeValues;
        this.attributeGroup = attributeGroup;
        this.attributeType = attributeType;
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

    public AttributeGroup getAttributeGroup() {
        return attributeGroup;
    }

    public void setAttributeGroup(AttributeGroup attributeGroup) {
        this.attributeGroup = attributeGroup;
    }

    public AttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(AttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public Set<AttributeValue> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Set<AttributeValue> attributeValues) {
        this.attributeValues = attributeValues;
    }
}
