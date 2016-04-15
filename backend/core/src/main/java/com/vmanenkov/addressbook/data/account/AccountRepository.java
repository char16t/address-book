package com.vmanenkov.addressbook.data.account;


import com.vmanenkov.addressbook.model.account.Account;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.List;

@Repository
public interface AccountRepository extends EntityRepository<Account, Long> {

    Account findOptionalById(Long id);

    @Query(value = "" +
            "SELECT a " +
            "  FROM Account as a" +
            "  JOIN a.roles as r" +
            " WHERE r.name = ?1", singleResult = SingleResultType.OPTIONAL)
    List<Account> findAccountsByRole(String role);

    Account findOptionalByEmail(String email);
}
