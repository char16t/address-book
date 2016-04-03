package com.vmanenkov.addressbook.model.contacts;

import com.vmanenkov.addressbook.model.account.Account;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
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

    @OneToMany
    private Set<Note> notes;

    @ManyToMany
    @JoinTable(name = "person_tag",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags;

    @ManyToMany
    @JoinTable(name = "attribute_value",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "attribute_id")})
    private Set<Attribute> attributes;

    @ManyToMany
    @JoinTable(name = "person_account",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<Account> accounts;

    public Person() {
    }

    public Person(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public Person(String firstName, String lastName, String description, Set<Note> notes, Set<Tag> tags, Set<Attribute> attributes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.notes = notes;
        this.tags = tags;
        this.attributes = attributes;
    }

    public Person(String firstName, String lastName, String description, Set<Note> notes, Set<Tag> tags, Set<Attribute> attributes, Set<Account> accounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.notes = notes;
        this.tags = tags;
        this.attributes = attributes;
        this.accounts = accounts;
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

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
