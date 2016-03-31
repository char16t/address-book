package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface FieldTypeService {
    FieldType create(String name, String description) throws FieldTypeNotValidException;

    FieldType get(Long id) throws FieldTypeNotFoundException;

    FieldType update(Long id, String name, String description) throws FieldTypeNotFoundException, FieldTypeNotValidException;

    void delete(Long id) throws FieldTypeNotFoundException;

    Collection<FieldType> getAll();
}
