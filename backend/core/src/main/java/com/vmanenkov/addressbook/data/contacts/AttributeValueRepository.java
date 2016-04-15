package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AttributeValueRepository extends EntityRepository<AttributeValue, Long> {
    AttributeValue findOptionalById(Long id);
}
