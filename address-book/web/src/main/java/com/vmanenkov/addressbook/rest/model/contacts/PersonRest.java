package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.account.AccountRest;

import java.util.Set;

public class PersonRest {
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private Set<NoteRest> notes;
    private Set<TagRest> tags;
    private Set<AttributeRest> attributes;
    private Set<AccountRest> accounts;

    public PersonRest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<NoteRest> getNotes() {
        return notes;
    }

    public void setNotes(Set<NoteRest> notes) {
        this.notes = notes;
    }

    public Set<TagRest> getTags() {
        return tags;
    }

    public void setTags(Set<TagRest> tags) {
        this.tags = tags;
    }

    public Set<AttributeRest> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<AttributeRest> attributes) {
        this.attributes = attributes;
    }

    public Set<AccountRest> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountRest> accounts) {
        this.accounts = accounts;
    }
}
