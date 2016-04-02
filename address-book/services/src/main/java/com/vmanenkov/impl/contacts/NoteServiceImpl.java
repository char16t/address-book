package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.NoteRepository;
import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.services.contacts.NoteService;
import com.vmanenkov.services.exceptions.NoteNotFoundException;
import com.vmanenkov.services.exceptions.NoteNotValidException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Date;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class NoteServiceImpl implements NoteService {

    @Inject
    private NoteRepository noteRepository;

    // TODO: Fill NoteServiceImpl::create
    @Override
    public Note create(Date date, String value, Person person) throws NoteNotValidException {
        return null;
    }

    // TODO: Fill NoteServiceImpl::get
    @Override
    public Note get(Long id) throws NoteNotFoundException {
        return null;
    }

    // TODO: Fill NoteServiceImpl::update
    @Override
    public Note update(Long id, Date date, String value, Person person) throws NoteNotFoundException, NoteNotValidException {
        return null;
    }

    @Override
    public void delete(Long id) throws NoteNotFoundException {
        Note note = get(id);
        noteRepository.remove(note);
    }

    @Override
    public Collection<Note> getAll() {
        return noteRepository.findAll();
    }
}
