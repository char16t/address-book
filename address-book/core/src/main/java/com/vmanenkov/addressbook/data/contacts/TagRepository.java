package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.Tag;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface TagRepository extends EntityRepository<Tag, Long> {
}
