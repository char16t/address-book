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
    private Set<AttributeValueRest> attributeValues;
    private Set<AccountRest> accounts;

    public PersonRest() {
    }

    public PersonRest(String description, String lastName, String firstName) {
        this.description = description;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public PersonRest(Long id, String firstName, String lastName, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
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

    public Set<AttributeValueRest> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Set<AttributeValueRest> attributeValues) {
        this.attributeValues = attributeValues;
    }

    public Set<AccountRest> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountRest> accounts) {
        this.accounts = accounts;
    }
}
