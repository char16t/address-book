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

    public AttributeValue() {
    }

    public AttributeValue(String textValue, byte[] blobValue) {
        this.textValue = textValue;
        this.blobValue = blobValue;
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
}
