package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AttributeGroupRepository extends EntityRepository<AttributeGroup, Long> {

    AttributeGroup findOptionalById(Long id);
}
