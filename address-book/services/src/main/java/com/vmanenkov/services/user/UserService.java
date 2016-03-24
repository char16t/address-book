package com.vmanenkov.services.user;

import com.vmanenkov.addressbook.model.user.Role;
import com.vmanenkov.addressbook.model.user.User;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface UserService {
    Set<User> getUsersByRole(Role role);
}
