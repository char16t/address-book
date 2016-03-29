package com.vmanenkov.addressbook.rest.model.contacts;

import java.util.Date;
import java.util.Set;

public class NoteRest {
    private Long id;
    private Date date;
    private String value;
    private Set<PersonRest> persons;

    public NoteRest() {
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

    public Set<PersonRest> getPersons() {
        return persons;
    }

    public void setPersons(Set<PersonRest> persons) {
        this.persons = persons;
    }
}
