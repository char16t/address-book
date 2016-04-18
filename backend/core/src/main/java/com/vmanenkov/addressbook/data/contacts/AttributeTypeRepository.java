package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeType;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AttributeTypeRepository extends EntityRepository <AttributeType, Long> {
    AttributeType findOptionalById(Long id);

    AttributeType findOptionalByName(String name);
}
