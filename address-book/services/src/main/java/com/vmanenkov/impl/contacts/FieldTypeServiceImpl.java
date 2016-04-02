package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.FieldTypeRepository;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.contacts.FieldTypeService;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Set;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class FieldTypeServiceImpl implements FieldTypeService {

    @Inject
    private FieldTypeRepository fieldTypeRepository;

    // TODO: Fill FieldTypeServiceImpl::create
    @Override
    public FieldType create(String typeName, Set<AttributeType> attributeTypes) throws FieldTypeNotValidException {
        return null;
    }

    // TODO: Fill FieldTypeServiceImpl::get
    @Override
    public FieldType get(Long id) throws FieldTypeNotFoundException {
        return null;
    }

    // TODO: Fill FieldTypeServiceImpl::update
    @Override
    public FieldType update(Long id, String typeName, Set<AttributeType> attributeTypes) throws FieldTypeNotFoundException, FieldTypeNotValidException {
        return null;
    }

    @Override
    public void delete(Long id) throws FieldTypeNotFoundException {
        FieldType fieldType = get(id);
        fieldTypeRepository.remove(fieldType);
    }

    @Override
    public Collection<FieldType> getAll() {
        return fieldTypeRepository.findAll();
    }
}
