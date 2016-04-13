package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.Tag;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.List;

@Repository
public interface TagRepository extends EntityRepository<Tag, Long> {
    Tag findOptionalById(Long id);

    @Query(value = "" +
            "SELECT t " +
            "  FROM Tag         t " +
            "  JOIN t.persons   tp " +
            "  JOIN tp.accounts tpa " +
            " WHERE tpa.id = ?1", singleResult = SingleResultType.OPTIONAL)
    List<Tag> findOptionalByAccountId(Long accountId);
}
