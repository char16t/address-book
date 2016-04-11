package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface FieldTypeService {
    FieldType create(String typeName) throws FieldTypeNotValidException;

    FieldType get(Long id) throws FieldTypeNotFoundException;

    FieldType update(Long id, String typeName) throws FieldTypeNotFoundException, FieldTypeNotValidException;

    FieldType getByName(String name);

    void delete(Long id) throws FieldTypeNotFoundException;

    Collection<FieldType> getAll();
}
