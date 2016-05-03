package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.AttributeListRepository;
import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.services.contacts.AttributeListService;
import com.vmanenkov.services.exceptions.AttributeListNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeListErrorType;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeListServiceImpl implements AttributeListService{

    @Inject
    private AttributeListRepository attributeListRepository;
    
    @Override
    public AttributeList create(String name, String description) throws AttributeListNotValidException {
        if (name == null || "".equals(name)) {
            throw new AttributeListNotValidException(AttributeListErrorType.ATTRIBUTE_LIST_NAME_IS_EMPTY);
        }

        AttributeList attributeList = new AttributeList(name, description);
        return attributeListRepository.save(attributeList);
    }

    @Override
    public AttributeList getById(Long id) throws AttributeListNotFoundException {
        AttributeList attributeList = attributeListRepository.findOptionalById(id);
        if (attributeList == null) {
            throw new AttributeListNotFoundException();
        }
        return attributeList;
    }

    @Override
    public AttributeList update(Long id, String name, String description) throws AttributeListNotFoundException, AttributeListNotValidException {
        AttributeList attributeList = getById(id);
        
        if ("".equals(name)) {
            throw new AttributeListNotValidException(AttributeListErrorType.ATTRIBUTE_LIST_NAME_IS_EMPTY);
        }

        if (name != null) {
            attributeList.setName(name);
        }

        if (description != null) {
            attributeList.setDescription(description);
        }

        return attributeListRepository.save(attributeList);        
    }

    @Override
    public void delete(Long id) throws AttributeListNotFoundException {
        AttributeList attributeList = getById(id);
        attributeListRepository.remove(attributeList);
    }

    @Override
    public Collection<AttributeList> getAll() {
        return attributeListRepository.findAll();
    }
    
}
