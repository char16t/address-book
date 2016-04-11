package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.contacts.Person;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends EntityRepository<Person, Long> {
    Person findOptionalById(Long id);

    @Query("select p from person p, person_account pa where p.id = pa.user_id and pa.user_id=?1")
    List<Person> findByAccountId(Long id);
}
