package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.AttributeTypeRepository;
import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.contacts.AttributeTypeService;
import com.vmanenkov.services.exceptions.AttributeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeNotValidException;
import com.vmanenkov.services.exceptions.AttributeTypeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeTypeNotValidException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Set;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeTypeServiceImpl implements AttributeTypeService {

    @Inject
    private AttributeTypeRepository attributeTypeRepository;

    // TODO: Fill AttributeTypeServiceImpl::create
    @Override
    public AttributeType create(String name, Set<Attribute> attributes, FieldType fieldType) throws AttributeTypeNotValidException {
        return null;
    }

    // TODO: Fill AttributeTypeServiceImpl::get
    @Override
    public AttributeType get(Long id) throws AttributeTypeNotFoundException {
        return null;
    }

    // TODO: Fill AttributeTypeServiceImpl::update
    @Override
    public AttributeType update(Long id, String name, Set<Attribute> attributes, FieldType fieldType) throws AttributeTypeNotFoundException, AttributeTypeNotValidException {
        return null;
    }

    // TODO: Fill AttributeTypeServiceImpl::delete
    @Override
    public void delete(Long id) throws AttributeTypeNotFoundException {

    }

    @Override
    public Collection<AttributeType> getAll() {
        return attributeTypeRepository.findAll();
    }
}
