package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;

// TODO: Setters and getters
// TODO: Default constructor
// TODO: relations
@Entity
@Table(name = "attribute_type")
public class AttributeType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "field_type_id")
    private Long fieldTypeId;

    @Column(name = "name")
    private String name;
}
