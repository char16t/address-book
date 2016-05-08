package com.vmanenkov.addressbook.model.contacts;

import com.vmanenkov.addressbook.model.DbEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attribute_list_value")
public class AttributeListValue implements DbEntity{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="attribute_list_id")
    private AttributeList attributeList;

    @Column(name = "value")
    private String value;

    public AttributeListValue() {
    }

    public AttributeListValue(Long id, AttributeList attributeList, String value) {
        this.id = id;
        this.attributeList = attributeList;
        this.value = value;
    }

    public AttributeListValue(AttributeList attributeList, String value) {
        this.attributeList = attributeList;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AttributeList getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(AttributeList attributeList) {
        this.attributeList = attributeList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
