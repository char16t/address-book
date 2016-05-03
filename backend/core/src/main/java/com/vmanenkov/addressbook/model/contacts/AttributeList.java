package com.vmanenkov.addressbook.model.contacts;

import com.vmanenkov.addressbook.model.DbEntity;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "attribute_list")
public class AttributeList implements DbEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    
    //@OneToMany(mappedBy = "attributeList")
    //private Set<Attribute> attrListValue;

    //@OneToMany(mappedBy = "attributeList")
    //private Set<Attribute> attrList;
    
    public AttributeList() {
    }

    public AttributeList(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public AttributeList(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
