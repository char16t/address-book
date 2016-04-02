package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;

import javax.ejb.Local;
import java.util.Collection;
import java.util.Set;

@Local
public interface FieldTypeService {
    FieldType create(String typeName) throws FieldTypeNotValidException;

    FieldType get(Long id) throws FieldTypeNotFoundException;

    FieldType update(Long id, String typeName) throws FieldTypeNotFoundException, FieldTypeNotValidException;

    void delete(Long id) throws FieldTypeNotFoundException;

    Collection<FieldType> getAll();
}
