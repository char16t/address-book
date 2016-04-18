package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.AttributeTypeRepository;
import com.vmanenkov.addressbook.model.contacts.AttributeType;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.contacts.AttributeTypeService;
import com.vmanenkov.services.exceptions.AttributeTypeNotFoundException;
import com.vmanenkov.services.exceptions.AttributeTypeNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeTypeErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeTypeServiceImpl implements AttributeTypeService {

    @Inject
    private AttributeTypeRepository attributeTypeRepository;

    @Override
    public AttributeType create(String name, FieldType fieldType) throws AttributeTypeNotValidException {
        if (name == null || "".equals(name)) {
            throw new AttributeTypeNotValidException(AttributeTypeErrorType.ATTRIBUTE_TYPE_NAME_IS_EMPTY);
        }

        if (getByName(name) != null) {
            throw new AttributeTypeNotValidException(AttributeTypeErrorType.ATTRIBUTE_TYPE_NAME_IS_NOT_UNIQUE);
        }

        if (fieldType == null) {
            throw new AttributeTypeNotValidException(AttributeTypeErrorType.ATTRIBUTE_TYPE_FIELD_TYPE_IS_EMPTY);
        }

        AttributeType attributeType = new AttributeType(name, fieldType);
        return attributeTypeRepository.save(attributeType);
    }

    @Override
    public AttributeType getByName(String name) {
        return attributeTypeRepository.findOptionalByName(name);
    }

    @Override
    public AttributeType get(Long id) throws AttributeTypeNotFoundException {
        AttributeType attributeType = attributeTypeRepository.findOptionalById(id);
        if (attributeType == null) {
            throw new AttributeTypeNotFoundException();
        }
        return attributeType;
    }

    @Override
    public AttributeType update(Long id, String name, FieldType fieldType) throws AttributeTypeNotFoundException, AttributeTypeNotValidException {
        AttributeType attributeType = get(id);

        if (name != null) {
            attributeType.setName(name);
        }

        if (fieldType != null) {
            attributeType.setFieldType(fieldType);
        }
        return attributeTypeRepository.save(attributeType);
    }

    @Override
    public void delete(Long id) throws AttributeTypeNotFoundException {
        AttributeType attributeType = get(id);
        attributeTypeRepository.remove(attributeType);
    }

    @Override
    public Collection<AttributeType> getAll() {
        return attributeTypeRepository.findAll();
    }

}
