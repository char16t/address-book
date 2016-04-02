package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.exceptions.AttributeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeNotValidException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.Collection;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeTypeServiceImpl implements AttributeService {
    // TODO: fill AttributeTypeServiceImpl::create
    @Override
    public Attribute create(String name, String description, AttributeGroup attributeGroup, AttributeType attributeType) throws AttributeNotValidException {
        return null;
    }

    // TODO: fill AttributeTypeServiceImpl::get
    @Override
    public Attribute get(Long id) throws AttributeNotFoundException {
        return null;
    }

    // TODO: fill AttributeTypeServiceImpl::update
    @Override
    public Attribute update(Long id, String name, String description, AttributeGroup attributeGroup, AttributeType attributeType) throws AttributeNotFoundException, AttributeNotValidException {
        return null;
    }

    // TODO: fill AttributeTypeServiceImpl::delete
    @Override
    public void delete(Long id) throws AttributeNotFoundException {

    }

    // TODO: fill AttributeTypeServiceImpl::getAll
    @Override
    public Collection<Attribute> getAll() {
        return null;
    }
}
