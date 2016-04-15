package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.RestEntity;

import java.util.Date;

public class NoteRest implements RestEntity {
    private Long id;
    private Date date;
    private String value;

    public NoteRest() {
    }

    public NoteRest(Long id, Date date, String value) {
        this.id = id;
        this.date = date;
        this.value = value;
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

    @Override
    public String toString() {
        return "NoteRest{" +
                "id=" + id +
                ", date=" + date +
                ", value='" + value + '\'' +
                '}';
    }
}
