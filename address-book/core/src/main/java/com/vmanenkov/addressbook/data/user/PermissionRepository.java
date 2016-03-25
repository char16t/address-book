package com.vmanenkov.addressbook.data.user;

import com.vmanenkov.addressbook.model.user.Permission;
import org.apache.deltaspike.data.api.EntityRepository;

public interface PermissionRepository extends EntityRepository<Permission, Long> {

}
