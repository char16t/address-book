package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.RestEntity;

public class AttributeValueRest implements RestEntity {
    private Long id;
    private String textValue;
    private byte[] blobValue;
    private AttributeRest attribute;

    public AttributeValueRest() {
    }

    public AttributeValueRest(Long id, String textValue, byte[] blobValue, AttributeRest attribute) {
        this.id = id;
        this.textValue = textValue;
        this.blobValue = blobValue;
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

    public AttributeRest getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeRest attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "AttributeValueRest{" +
                "id=" + id +
                ", textValue='" + textValue + '\'' +
                ", attribute=" + attribute +
                '}';
    }
}
