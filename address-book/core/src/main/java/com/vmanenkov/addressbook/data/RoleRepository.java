package com.vmanenkov.addressbook.data;

import com.vmanenkov.addressbook.model.user.Role;
import com.vmanenkov.addressbook.model.user.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface RoleRepository  extends EntityRepository<Role, Long> {
    Role getByName(String name);
}
