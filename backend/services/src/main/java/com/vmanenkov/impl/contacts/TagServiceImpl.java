package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.TagRepository;
import com.vmanenkov.addressbook.model.contacts.Tag;
import com.vmanenkov.services.contacts.TagService;
import com.vmanenkov.services.exceptions.TagNotFoundException;
import com.vmanenkov.services.exceptions.TagNotValidException;
import com.vmanenkov.services.exceptions.errortypes.TagErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashSet;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TagServiceImpl implements TagService {

    @Inject
    private TagRepository tagRepository;

    @Override
    public Tag create(String name, Boolean publicTag, String description) throws TagNotValidException {
        if (name == null || "".equals(name)) {
            throw new TagNotValidException(TagErrorType.TAG_NAME_IS_EMPTY);
        }

        Tag tag = new Tag(name, publicTag, description);
        return tagRepository.save(tag);
    }

    @Override
    public Tag get(Long id) throws TagNotFoundException {
        Tag tag = tagRepository.findOptionalById(id);
        if (tag == null) {
            throw new TagNotFoundException();
        }

        return tagRepository.save(tag);
    }

    @Override
    public Tag update(Long id, String name, Boolean publicTag, String description) throws TagNotFoundException, TagNotValidException {
        Tag tag = get(id);
        if (name == null || ("".equals(name))) {
            throw new TagNotValidException(TagErrorType.TAG_NAME_IS_EMPTY);
        }
        tag.setName(name);
        tag.setPublicTag(publicTag);
        tag.setDescription(description);

        return tagRepository.save(tag);
    }

    @Override
    public void delete(Long id) throws TagNotFoundException {
        Tag tag = get(id);
        tagRepository.remove(tag);
    }

    @Override
    public Collection<Tag> getAllPublic() {
        //return tagRepository.findAll(); //findPublicTags();
        return new HashSet<>(tagRepository.findOptionalPublicTags());
    }

    @Override
    public Collection<Tag> getPrivateByAccount(Long accountId) {
        return new HashSet<>(tagRepository.findOptionalPrivateTagsByAccountId(accountId));        
    }

    @Override
    public Collection<Tag> getByAccount(Long accountId) {
        return new HashSet<>(tagRepository.findOptionalByAccountId(accountId));
    }

    @Override
    public Collection<Tag> getByPerson(Long personId) {
        return new HashSet<>(tagRepository.findOptionalByPersonId(personId)); 
    }
    
}
