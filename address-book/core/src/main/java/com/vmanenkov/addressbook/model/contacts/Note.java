package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;
import java.util.Date;

// TODO: Setters and getters
// TODO: Default constructor
// TODO: Many to many relations
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private String value;
}
