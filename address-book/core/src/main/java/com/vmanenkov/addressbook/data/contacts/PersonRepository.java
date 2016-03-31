package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.Person;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface PersonRepository extends EntityRepository<Person, Long> {
    Person findOptionalById(Long id);
}
