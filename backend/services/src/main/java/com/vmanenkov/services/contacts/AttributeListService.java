package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.services.exceptions.AttributeListNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListNotValidException;
import java.util.Collection;

import javax.ejb.Local;

@Local
public interface AttributeListService {
    AttributeList create(String name, String description) throws AttributeListNotValidException;

    AttributeList getById(Long id) throws AttributeListNotFoundException;

    AttributeList getByName(String name);

    AttributeList update(Long id, String name, String description) throws AttributeListNotFoundException, AttributeListNotValidException;

    void delete(Long id) throws AttributeListNotFoundException;

    Collection<AttributeList> getAll();

}
