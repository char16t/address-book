package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.contacts.Attribute;
import com.vmanenkov.addressbook.model.contacts.AttributeValue;
import com.vmanenkov.addressbook.model.contacts.Person;
import com.vmanenkov.addressbook.model.contacts.Tag;
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
            "  FROM Person     p " +
            "  JOIN p.accounts pa " +
            " WHERE pa.id = ?1", singleResult = SingleResultType.OPTIONAL)
    List<Person> findByAccountId(Long id);

    @Query(value = "" +
            "SELECT p " +
            "  FROM Person     p  " +
            "  JOIN p.accounts pa " +
            "  JOIN p.tags     t  " +
            " WHERE pa = ?1 " +
            "   AND t  = ?2", singleResult = SingleResultType.OPTIONAL)
    List<Person> findOptionalByAccountAndTag(Account account, Tag tag);

    @Query(value = "" +
            "SELECT p " +
            "  FROM Person p " +
            "  WHERE "+
            "      p.id in (select p1.id from Person p1 join p1.accounts pa1 join p1.attributeValues pav1 where pa1 = ?1 and lower(pav1.textValue) like ?2)" +
            "   or p.id in (select p2.id from Person p2 join p2.accounts pa2 where pa2 = ?1 and (lower(p2.firstName) like ?2 OR lower(p2.lastName) like ?2))"
            , singleResult = SingleResultType.OPTIONAL)
    List<Person> findOptionalByAllFields(Account account, String query);
}
