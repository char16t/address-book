package com.vmanenkov.addressbook.data.user;


import com.vmanenkov.addressbook.model.user.Account;
import com.vmanenkov.addressbook.model.user.Role;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.Set;

@Repository
public interface AccountRepository extends EntityRepository<Account, Long> {
    Account findOptionalById(Long id);

    @Query(value = "select a from Account as a where a.roles in ?1", singleResult = SingleResultType.ANY)
    Set<Account> findAccountsByRole(Set<Role> roles);

}
