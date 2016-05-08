package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeList;
import com.vmanenkov.addressbook.model.contacts.AttributeListValue;
import com.vmanenkov.services.exceptions.AttributeListNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListValueNotFoundException;
import com.vmanenkov.services.exceptions.AttributeListValueNotValidException;

import java.util.Collection;
import javax.ejb.Local;

@Local
public interface AttributeListValueService {
    AttributeListValue create(AttributeList attributeList, String value) throws AttributeListValueNotValidException, AttributeListNotFoundException;

    AttributeListValue getById(Long id) throws AttributeListValueNotFoundException;

    AttributeListValue update(Long id, /*AttributeList attributeList,*/ String value) throws AttributeListValueNotFoundException, AttributeListValueNotValidException;

    void delete(Long id) throws AttributeListValueNotFoundException;

    Collection<AttributeListValue> getAllByListId(Long id);
    
    AttributeListValue getByValueInList(Long listId, String value);
}
