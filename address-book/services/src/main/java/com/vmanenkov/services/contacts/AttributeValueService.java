package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeValueNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface AttributeValueService {
    AttributeValue create(String name, String description) throws AttributeValueNotValidException;

    AttributeValue get(Long id) throws AttributeValueNotFoundException;

    AttributeValue update(Long id, String name, String description) throws AttributeValueNotFoundException, AttributeValueNotValidException;

    void delete(Long id) throws AttributeValueNotFoundException;

    Collection<AttributeValue> getAll();
}
