package com.vmanenkov.addressbook.data.user;


import com.vmanenkov.addressbook.model.user.Account;
import com.vmanenkov.addressbook.model.user.Role;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.Set;

public interface AccountRepository extends EntityRepository<Account, Long> {
    Account findOptionalById(Long id);

    @Query(value = "select u from User as u where u.role=role", singleResult = SingleResultType.ANY)
    Set<Account> findAccountsByRole(Role role);

}
