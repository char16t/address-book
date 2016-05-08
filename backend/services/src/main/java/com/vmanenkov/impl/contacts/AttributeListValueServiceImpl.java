package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.AttributeListValueRepository;
import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.addressbook.model.contacts.AttributeListValue;
import com.vmanenkov.services.contacts.AttributeListValueService;
import com.vmanenkov.services.exceptions.AttributeListNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListValueNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeListValueErrorType;
import java.util.Collection;
import java.util.HashSet;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeListValueServiceImpl implements AttributeListValueService{
    
    @Inject
    private AttributeListValueRepository attributeListValueRepository;
    
    @Override
    public AttributeListValue create(AttributeList attributeList, String value) throws AttributeListValueNotValidException, AttributeListNotFoundException {
        if (value == null || "".equals(value)) {
            throw new AttributeListValueNotValidException(AttributeListValueErrorType.ATTRIBUTE_LIST_VALUE_IS_EMPTY);
        }

        if (attributeList == null) {
            throw new AttributeListNotFoundException();
        }

        if (getByValueInList(attributeList.getId(), value) != null) {
            throw new AttributeListValueNotValidException(AttributeListValueErrorType.ATTRIBUTE_LIST_VALUE_IS_NOT_UNIQIE);
        }
        
        AttributeListValue attributeListValue = new AttributeListValue(attributeList, value);
        return attributeListValueRepository.save(attributeListValue);
    }
    
    @Override
    public AttributeListValue getById(Long id) throws AttributeListValueNotFoundException {
        AttributeListValue attributeListValue = attributeListValueRepository.findOptionalById(id);
        if (attributeListValue == null) {
            throw new AttributeListValueNotFoundException();
        }
        return attributeListValue;
    }

    @Override
    public AttributeListValue update(Long id, /*AttributeList attributeList,*/ String value) 
            throws AttributeListValueNotFoundException, AttributeListValueNotValidException {
        AttributeListValue attributeListValue = getById(id);
        AttributeList attributeList = attributeListValue.getAttributeList();
        
        if ("".equals(value)) {
            throw new AttributeListValueNotValidException(AttributeListValueErrorType.ATTRIBUTE_LIST_VALUE_IS_EMPTY);
        }
        
        if (getByValueInList(attributeList.getId(), value) != null) {
            throw new AttributeListValueNotValidException(AttributeListValueErrorType.ATTRIBUTE_LIST_VALUE_IS_NOT_UNIQIE);
        }

        if (value != null) {
            attributeListValue.setValue(value);
        }

        /*if (attributeList != null) {
            attributeListValue.setAttributeList(attributeList);
        }*/

        return attributeListValueRepository.save(attributeListValue);        
    }

    @Override
    public AttributeListValue getByValueInList(Long listId, String value) { //AttributeList attributeList) {
        return attributeListValueRepository.findOptionalByValueInList(listId, value);
    }

    @Override
    public void delete(Long id) throws AttributeListValueNotFoundException {
        AttributeListValue attributeListValue = getById(id);
        attributeListValueRepository.remove(attributeListValue);
    }

    @Override
    public Collection<AttributeListValue> getAllByListId(Long id) {
        return new HashSet<>(attributeListValueRepository.findOptionalByAttributeListId(id));
    }
}
