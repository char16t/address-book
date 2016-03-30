package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.services.exceptions.AttributeGroupNotFoundException;
import com.vmanenkov.services.exceptions.AttributeGroupNotValidException;

import javax.ejb.Local;

@Local
public interface AttributeGroupService {
    AttributeGroup create(String name, String description) throws AttributeGroupNotValidException;

    AttributeGroup get(Long id) throws AttributeGroupNotFoundException;

    AttributeGroup update(Long id, String name, String description) throws AttributeGroupNotFoundException, AttributeGroupNotValidException;

    void delete(Long id) throws AttributeGroupNotFoundException;
}
