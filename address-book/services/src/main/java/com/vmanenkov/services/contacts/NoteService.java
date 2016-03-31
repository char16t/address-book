package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.services.exceptions.NoteNotFoundException;
import com.vmanenkov.services.exceptions.NoteNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface NoteService {
    Note create(String name, String description) throws NoteNotValidException;

    Note get(Long id) throws NoteNotFoundException;

    Note update(Long id, String name, String description) throws NoteNotFoundException, NoteNotValidException;

    void delete(Long id) throws NoteNotFoundException;

    Collection<Note> getAll();
}
