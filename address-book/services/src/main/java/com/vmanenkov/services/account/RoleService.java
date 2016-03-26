package com.vmanenkov.services.account;

import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.services.exceptions.UserRoleNotFoundException;

import javax.ejb.Local;

@Local
public interface RoleService {
    Role getByName(String string) throws UserRoleNotFoundException;
}
