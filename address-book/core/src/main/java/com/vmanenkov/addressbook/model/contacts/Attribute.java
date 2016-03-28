package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;
import java.util.Set;

// TODO: Setters and getters
// TODO: Default constructor
// TODO: Many to many relations (type_id, group_id)
@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "attribute_value",
            joinColumns = {@JoinColumn(name = "attribute_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private Set<Person> persons;
}
