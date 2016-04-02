package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.services.contacts.AttributeValueService;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeValueNotValidException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.Collection;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeValueServiceImpl implements AttributeValueService {
    // TODO: Fill AttributeValueServiceImpl::create
    @Override
    public AttributeValue create(String textValue, byte[] blobValue) throws AttributeValueNotValidException {
        return null;
    }

    // TODO: Fill AttributeValueServiceImpl::get
    @Override
    public AttributeValue get(Long id) throws AttributeValueNotFoundException {
        return null;
    }

    // TODO: Fill AttributeValueServiceImpl::update
    @Override
    public AttributeValue update(Long id, String textValue, byte[] blobValue) throws AttributeValueNotFoundException, AttributeValueNotValidException {
        return null;
    }

    // TODO: Fill AttributeValueServiceImpl::delete
    @Override
    public void delete(Long id) throws AttributeValueNotFoundException {

    }

    // TODO: Fill AttributeValueServiceImpl::getAll
    @Override
    public Collection<AttributeValue> getAll() {
        return null;
    }
}
