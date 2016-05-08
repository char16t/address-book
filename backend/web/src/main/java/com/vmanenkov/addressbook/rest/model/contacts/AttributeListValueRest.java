package com.vmanenkov.addressbook.rest.model.contacts;

import com.vmanenkov.addressbook.rest.model.RestEntity;

public class AttributeListValueRest implements RestEntity {
    private Long id;
    private AttributeListRest attributeList;
    private String value;

    public AttributeListValueRest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AttributeListRest getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(AttributeListRest attributeList) {
        this.attributeList = attributeList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "AttributeListValueRest{" +
                "id=" + id +
                ", attribute_list_id='" + attributeList + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
