package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.FieldType;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface FieldTypeRepository extends EntityRepository<FieldType, Long> {
    FieldType findOptionalById(Long id);
    FieldType findOptionalByTypeName(String typeName);
}
