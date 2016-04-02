package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.PersonRepository;
import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
import com.vmanenkov.services.exceptions.PersonNotValidException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Set;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonRepository personRepository;

    // TODO: Fill PersonServiceImpl::create
    @Override
    public Person create(String firstName, String lastName, String description, Set<Note> notes, Set<Tag> tags, Set<Attribute> attributes) throws PersonNotValidException {
        return null;
    }

    // TODO: Fill PersonServiceImpl::get
    @Override
    public Person get(Long id) throws PersonNotFoundException {
        return null;
    }

    // TODO: Fill PersonServiceImpl::update
    @Override
    public Person update(Long id, String firstName, String lastName, String description, Set<Note> notes, Set<Tag> tags, Set<Attribute> attributes) throws PersonNotFoundException, PersonNotValidException {
        return null;
    }

    @Override
    public void delete(Long id) throws PersonNotFoundException {
        Person person = get(id);
        personRepository.remove(person);
    }

    @Override
    public Collection<Person> getAll() {
        return personRepository.findAll();
    }
}
