package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.Note;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.List;

@Repository
public interface NoteRepository extends EntityRepository<Note, Long> {
    Note findOptionalById(Long id);

    @Query(value = "" +
            "SELECT n " +
            "  FROM Note n " +
            "  JOIN n.person np " +
            " WHERE np.id = ?1", singleResult = SingleResultType.OPTIONAL)
    List<Note> findByPersonId(Long personId);
}
