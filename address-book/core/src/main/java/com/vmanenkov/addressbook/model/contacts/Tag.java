package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;

// TODO: Setters and getters
// TODO: Default constructor
// TODO: Many to many relations
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
