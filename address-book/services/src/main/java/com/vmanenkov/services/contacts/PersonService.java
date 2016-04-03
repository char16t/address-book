package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
import com.vmanenkov.services.exceptions.PersonNotValidException;

import javax.ejb.Local;
import java.util.Collection;
import java.util.Set;

@Local
public interface PersonService {
    Person create(String firstName, String lastName, String description) throws PersonNotValidException;

    Person get(Long id) throws PersonNotFoundException;

    Person update(Long id, String firstName, String lastName, String description) throws PersonNotFoundException, PersonNotValidException;

    void delete(Long id) throws PersonNotFoundException;

    Collection<Person> getAll();
}
