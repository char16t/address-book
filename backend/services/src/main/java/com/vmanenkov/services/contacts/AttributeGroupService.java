package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.services.exceptions.AttributeGroupNotFoundException;
import com.vmanenkov.services.exceptions.AttributeGroupNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface AttributeGroupService {
    AttributeGroup create(String name, String description) throws AttributeGroupNotValidException;

    AttributeGroup get(Long id) throws AttributeGroupNotFoundException;

    AttributeGroup getByName(String name);

    AttributeGroup update(Long id, String name, String description) throws AttributeGroupNotFoundException, AttributeGroupNotValidException;

    void delete(Long id) throws AttributeGroupNotFoundException;

    Collection<AttributeGroup> getAll();
}
