package com.vmanenkov.addressbook.model.contacts;

import com.vmanenkov.addressbook.model.DbEntity;

import javax.persistence.*;

@Entity
@Table(name = "attribute_value")
public class AttributeValue implements DbEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text_value")
    private String textValue;

    @Column(name = "blob_value")
    private byte[] blobValue;

    @JoinColumn(name = "attribute_id")
    @ManyToOne(optional = false)
    private Attribute attribute;

    @JoinColumn(name = "person_id")
    @ManyToOne(optional = false)
    private Person person;

    @JoinColumn(name = "list_value_id")
    @ManyToOne(optional = true)
    private AttributeListValue attributeListValue;
    
    public AttributeValue() {
    }

    public AttributeValue(String textValue, byte[] blobValue, Person person, Attribute attribute, AttributeListValue attributeListValue) {
        this.textValue = textValue;
        this.blobValue = blobValue;
        this.person = person;
        this.attribute = attribute;
        this.attributeListValue = attributeListValue;
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

    public AttributeListValue getAttributeListValue() {
        return attributeListValue;
    }

    public void setAttributeListValue(AttributeListValue attributeListValue) {
        this.attributeListValue = attributeListValue;
    }
}
