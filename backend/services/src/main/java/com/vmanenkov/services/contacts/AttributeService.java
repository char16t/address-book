package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.services.exceptions.AttributeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface AttributeService {
    Attribute create(String name, String description, AttributeGroup attributeGroup, AttributeType attributeType) throws AttributeNotValidException;

    Attribute get(Long id) throws AttributeNotFoundException;

    Attribute update(Long id, String name, String description, AttributeGroup attributeGroup, AttributeType attributeType) throws AttributeNotFoundException, AttributeNotValidException;

    void delete(Long id) throws AttributeNotFoundException;

    Collection<Attribute> getAll();
}
