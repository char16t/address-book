package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.services.exceptions.AttributeValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeValueNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface AttributeValueService {
    AttributeValue create(String textValue, byte[] blobValue, Person person, Attribute attribute) throws AttributeValueNotValidException;

    AttributeValue get(Long id) throws AttributeValueNotFoundException;

    AttributeValue update(Long id, String textValue, byte[] blobValue) throws AttributeValueNotFoundException, AttributeValueNotValidException;

    void delete(Long id) throws AttributeValueNotFoundException;

    Collection<AttributeValue> getAll();
}
