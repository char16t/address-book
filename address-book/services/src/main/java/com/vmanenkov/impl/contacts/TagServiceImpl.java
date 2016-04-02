package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.TagRepository;
import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.services.contacts.TagService;
import com.vmanenkov.services.exceptions.TagNotFoundException;
import com.vmanenkov.services.exceptions.TagNotValidException;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TagServiceImpl implements TagService {

    @Inject
    private TagRepository tagRepository;

    // TODO: Fill TagServiceImpl::create
    @Override
    public Tag create(String name, String description) throws TagNotValidException {
        return null;
    }

    // TODO: Fill TagServiceImpl::get
    @Override
    public Tag get(Long id) throws TagNotFoundException {
        return null;
    }

    // TODO: Fill TagServiceImpl::update
    @Override
    public Tag update(Long id, String name, String description) throws TagNotFoundException, TagNotValidException {
        return null;
    }

    // TODO: Fill TagServiceImpl::delete
    @Override
    public void delete(Long id) throws TagNotFoundException {

    }

    @Override
    public Collection<Tag> getAll() {
        return tagRepository.findAll();
    }
}
