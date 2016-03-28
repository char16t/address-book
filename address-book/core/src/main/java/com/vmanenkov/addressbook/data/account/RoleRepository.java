package com.vmanenkov.addressbook.data.account;

import com.vmanenkov.addressbook.model.account.Role;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

@Repository
public interface RoleRepository extends EntityRepository<Role, Long> {
    @Query(singleResult = SingleResultType.OPTIONAL)
    Role findByName(String name);
}
