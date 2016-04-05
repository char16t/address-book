package com.vmanenkov.addressbook.rest.model.contacts;

public class AttributeValueRest {
    private Long id;
    private String textValue;
    private byte[] blobValue;

    public AttributeValueRest() {
    }

    public AttributeValueRest(Long id, String textValue, byte[] blobValue) {
        this.id = id;
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
