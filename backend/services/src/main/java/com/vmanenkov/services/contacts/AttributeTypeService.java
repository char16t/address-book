package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.exceptions.AttributeTypeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeTypeNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface AttributeTypeService {
    AttributeType create(String name, FieldType fieldType) throws AttributeTypeNotValidException;

    AttributeType get(Long id) throws AttributeTypeNotFoundException;

    AttributeType update(Long id, String name, FieldType fieldType) throws AttributeTypeNotFoundException, AttributeTypeNotValidException;

    void delete(Long id) throws AttributeTypeNotFoundException;

    Collection<AttributeType> getAll();

    AttributeType getByName(String name);
}