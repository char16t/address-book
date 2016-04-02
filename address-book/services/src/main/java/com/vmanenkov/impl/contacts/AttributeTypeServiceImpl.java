package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.exceptions.AttributeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeNotValidException;

import java.util.Collection;

public class AttributeTypeServiceImpl implements AttributeService {
    @Override
    public Attribute create(String name, String description, AttributeGroup attributeGroup, AttributeType attributeType) throws AttributeNotValidException {
        return null;
    }

    @Override
    public Attribute get(Long id) throws AttributeNotFoundException {
        return null;
    }

    @Override
    public Attribute update(Long id, String name, String description, AttributeGroup attributeGroup, AttributeType attributeType) throws AttributeNotFoundException, AttributeNotValidException {
        return null;
    }

    @Override
    public void delete(Long id) throws AttributeNotFoundException {

    }

    @Override
    public Collection<Attribute> getAll() {
        return null;
    }
}
