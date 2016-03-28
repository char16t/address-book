package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;

// TODO: Setters and getters
// TODO: Default constructor
// TODO: relations
@Entity
@Table(name = "field_type")
public class FieldType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name")
    private String typeName;
}
