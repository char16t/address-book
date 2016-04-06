package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.model.contacts.Person;

import java.util.Date;

public class NoteRest {
    private Long id;
    private Date date;
    private String value;
    private Person person; // todo: 2 VM this is strangely

    public NoteRest() {
    }

    public NoteRest(Long id, Date date, String value, Person person) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.person = person;
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
