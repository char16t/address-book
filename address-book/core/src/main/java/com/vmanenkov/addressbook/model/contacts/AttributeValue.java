package com.vmanenkov.addressbook.model.contacts;

import javax.persistence.*;

@Entity
@Table(name = "attribute_value")
public class AttributeValue {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text_value")
    private String textValue;

    @Column(name = "blob_value")
    private byte[] blobValue;

    @Column(name = "attribute_id")
    private Attribute attribute;

    @JoinColumn(name = "person_id")
    @ManyToOne(optional = false)
    private Person person;

    public AttributeValue() {
    }

    public AttributeValue(String textValue, byte[] blobValue, Person person, Attribute attribute) {
        this.textValue = textValue;
        this.blobValue = blobValue;
        this.person = person;
        this.attribute = attribute;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public byte[] getBlobValue() {
        return blobValue;
    }

    public void setBlobValue(byte[] blobValue) {
        this.blobValue = blobValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
