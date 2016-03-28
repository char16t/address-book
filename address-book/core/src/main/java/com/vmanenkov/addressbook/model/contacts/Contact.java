package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;

// TODO: Setters and getters
// TODO: Default constructor
// TODO: Many to many relations
@Entity
@Table(name = "person")
public class Contact {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "description")
    private String description;
}
