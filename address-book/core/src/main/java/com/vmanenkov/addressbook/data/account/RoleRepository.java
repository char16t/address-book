package com.vmanenkov.addressbook.data.account;

import com.vmanenkov.addressbook.model.user.Role;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface RoleRepository extends EntityRepository<Role, Long> {
    Role findByName(String name);
}
