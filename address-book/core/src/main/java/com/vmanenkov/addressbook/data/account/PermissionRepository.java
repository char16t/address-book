package com.vmanenkov.addressbook.data.account;

import com.vmanenkov.addressbook.model.user.Permission;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface PermissionRepository extends EntityRepository<Permission, Long> {

}
