package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.contacts.Person;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.List;

@Repository
public interface PersonRepository extends EntityRepository<Person, Long> {
    Person findOptionalById(Long id);

    @Query(value = "" +
            "SELECT p " +
            "  FROM Person    p " +
            "  JOIN p.accounts pa " +
            " WHERE pa.id = ?1", singleResult = SingleResultType.OPTIONAL)
    List<Person> findByAccountId(Long id);
}
