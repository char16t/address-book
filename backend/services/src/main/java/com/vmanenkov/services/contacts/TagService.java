package com.vmanenkov.services.contacts;

import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.services.exceptions.TagNotFoundException;
import com.vmanenkov.services.exceptions.TagNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface TagService {
    Tag create(String name, Boolean publicTag, String description) throws TagNotValidException;

    Tag get(Long id) throws TagNotFoundException;

    Tag update(Long id, String name, Boolean publicTag, String description) throws TagNotFoundException, TagNotValidException;

    void delete(Long id) throws TagNotFoundException;

    //Collection<Tag> getAll();

    Collection<Tag> getByAccount(Long accountId);

    Collection<Tag> getAllPublic();
    
    Collection<Tag> getPrivateByAccount(Long accountId);
            
    Collection<Tag> getByPerson(Long personId);
}
