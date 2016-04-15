package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.services.exceptions.NoteNotFoundException;
import com.vmanenkov.services.exceptions.NoteNotValidException;

import javax.ejb.Local;
import java.util.Collection;
import java.util.Date;

@Local
public interface NoteService {
    Note create(Date date, String value, Person person) throws NoteNotValidException;

    Note get(Long id) throws NoteNotFoundException;

    Note update(Long id, Date date, String value, Person person) throws NoteNotFoundException, NoteNotValidException;

    void delete(Long id) throws NoteNotFoundException;

    Collection<Note> getAll();

    Collection<Note> getByPersonId(Long personId);
}
