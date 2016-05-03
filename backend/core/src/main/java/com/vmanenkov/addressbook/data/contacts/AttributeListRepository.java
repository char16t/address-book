package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeList;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AttributeListRepository extends EntityRepository<AttributeList, Long>{
    AttributeList findOptionalById(Long id);
    
}
