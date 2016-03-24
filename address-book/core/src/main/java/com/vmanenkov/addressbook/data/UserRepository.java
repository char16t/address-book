package com.vmanenkov.addressbook.data;

import com.vmanenkov.addressbook.model.user.Role;
import com.vmanenkov.addressbook.model.user.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

import java.util.Set;

@Repository
public interface UserRepository extends EntityRepository<User, Long> {
    User findOptionalById(Long id);

    @Query(value = "select u from User as u where u.role=role", singleResult = SingleResultType.ANY)
    Set<User> findUsersByRole(Role role);
}
