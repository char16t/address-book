package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.PersonRepository;
import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.services.contacts.PersonService;
import com.vmanenkov.services.exceptions.PersonNotFoundException;
import com.vmanenkov.services.exceptions.PersonNotValidException;
import com.vmanenkov.services.exceptions.errortypes.PersonErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashSet;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonRepository personRepository;

    @Override
    public Person create(String firstName, String lastName, String description) throws PersonNotValidException {
        if (firstName == null || "".equals(firstName)) {
            throw new PersonNotValidException(PersonErrorType.PERSON_FIRST_NAME_IS_EMPTY);
        }
        if (lastName == null || "".equals(lastName)) {
            throw new PersonNotValidException(PersonErrorType.PERSON_LAST_NAME_IS_EMPTY);
        }
        Person person = new Person(firstName, lastName, description);
        return personRepository.save(person);
    }

    @Override
    public Person get(Long id) throws PersonNotFoundException {
        Person person = personRepository.findOptionalById(id);
        if (person == null) {
            throw new PersonNotFoundException();
        }
        return person;
    }

    @Override
    public Person update(Long id, String firstName, String lastName, String description) throws PersonNotFoundException, PersonNotValidException {
        Person person = get(id);
        if (firstName == null || "".equals(firstName)) {
            throw new PersonNotValidException(PersonErrorType.PERSON_FIRST_NAME_IS_EMPTY);
        }
        if (lastName == null || "".equals(lastName)) {
            throw new PersonNotValidException(PersonErrorType.PERSON_LAST_NAME_IS_EMPTY);
        }

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDescription(description);

        return personRepository.save(person);
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

    @Override
    public Collection<Person> getByAccountId(Long id) {
        return new HashSet<>(personRepository.findByAccountId(id));
    }

    @Override
    public Collection<Person> getByAccountAndTag(Account account, Tag tag) {
        return new HashSet<>(personRepository.findOptionalByAccountAndTag(account, tag));
    }
}
