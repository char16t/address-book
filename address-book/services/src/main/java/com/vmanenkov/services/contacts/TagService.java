package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.services.exceptions.TagNotFoundException;
import com.vmanenkov.services.exceptions.TagNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface TagService {
    Tag create(String name, String description) throws TagNotValidException;

    Tag get(Long id) throws TagNotFoundException;

    Tag update(Long id, String name, String description) throws TagNotFoundException, TagNotValidException;

    void delete(Long id) throws TagNotFoundException;

    Collection<Tag> getAll();
}
