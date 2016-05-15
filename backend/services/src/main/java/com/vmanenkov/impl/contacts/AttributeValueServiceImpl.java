package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.AttributeValueRepository;
import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeListValue;
import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.services.contacts.AttributeValueService;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeValueNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeValueErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeValueServiceImpl implements AttributeValueService {

    @Inject
    private AttributeValueRepository attributeValueRepository;

    @Override
    public AttributeValue create(String textValue, byte[] blobValue, Person person, Attribute attribute, AttributeListValue attributeListValue) throws AttributeValueNotValidException {
        if (textValue == null && blobValue == null && attributeListValue == null) {
            throw new AttributeValueNotValidException(AttributeValueErrorType.ATTRIBUTE_VALUE_IS_EMPTY);
        }
        AttributeValue attributeValue = new AttributeValue(textValue, blobValue, person, attribute, attributeListValue);
        return attributeValueRepository.save(attributeValue);
    }

    @Override
    public AttributeValue get(Long id) throws AttributeValueNotFoundException {
        return attributeValueRepository.findOptionalById(id);
    }

    @Override
    public AttributeValue update(Long id, String textValue, byte[] blobValue, AttributeListValue attributeListValue) throws AttributeValueNotFoundException, AttributeValueNotValidException {
        if (textValue == null && blobValue == null && attributeListValue == null) {
            throw new AttributeValueNotValidException(AttributeValueErrorType.ATTRIBUTE_VALUE_IS_EMPTY);
        }
        AttributeValue attributeValue = get(id);
        attributeValue.setTextValue(textValue);
        attributeValue.setBlobValue(blobValue);
        attributeValue.setAttributeListValue(attributeListValue);

        return attributeValueRepository.save(attributeValue);
    }

    @Override
    public void delete(Long id) throws AttributeValueNotFoundException {
        AttributeValue attributeValue = get(id);
        attributeValueRepository.remove(attributeValue);
    }

    @Override
    public Collection<AttributeValue> getAll() {
        return attributeValueRepository.findAll();
    }
}
