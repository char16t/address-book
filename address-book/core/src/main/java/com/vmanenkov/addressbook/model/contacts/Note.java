package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
