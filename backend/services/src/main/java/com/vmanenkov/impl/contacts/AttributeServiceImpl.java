package com.vmanenkov.impl.contacts;


import com.vmanenkov.addressbook.data.contacts.AttributeRepository;
import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.services.contacts.AttributeService;
import com.vmanenkov.services.exceptions.AttributeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeServiceImpl implements AttributeService {

    @Inject
    private AttributeRepository attributeRepository;

    @Override
    public Attribute create(String name, String description, AttributeGroup attributeGroup, 
            AttributeType attributeType, AttributeList attributeList) throws AttributeNotValidException {
        if (name == null || "".equals(name)) {
            throw new AttributeNotValidException(AttributeErrorType.ATTRIBUTE_NAME_IS_EMPTY);
        }

        Attribute attribute = new Attribute(name, description, null, attributeGroup, attributeType, attributeList);
        return attributeRepository.save(attribute);
    }

    @Override
    public Attribute get(Long id) throws AttributeNotFoundException {
        Attribute attribute = attributeRepository.findOptionalById(id);
        if (attribute == null) {
            throw new AttributeNotFoundException();
        }
        return attribute;
    }

    @Override
    public Attribute update(Long id, String name, String description, AttributeGroup attributeGroup, 
            AttributeType attributeType, AttributeList attributeList) throws AttributeNotFoundException, AttributeNotValidException {
        Attribute attribute = get(id);
        if (name != null) {
            if ("".equals(name)) {
                throw new AttributeNotValidException(AttributeErrorType.ATTRIBUTE_NAME_IS_EMPTY);
            }
            attribute.setName(name);
        }
        if (description != null) {
            attribute.setDescription(description);
        }

        if (attributeGroup != null) {
            attribute.setAttributeGroup(attributeGroup);
        }

        if (attributeType != null) {
            attribute.setAttributeType(attributeType);
        }

        //if (attributeList != null) {
            attribute.setAttributeList(attributeList);
        //}

        return attributeRepository.save(attribute);
    }

    @Override
    public void delete(Long id) throws AttributeNotFoundException {
        Attribute attribute = get(id);
        attributeRepository.remove(attribute);
    }

    @Override
    public Collection<Attribute> getAll() {
        return attributeRepository.findAll();
    }
}
