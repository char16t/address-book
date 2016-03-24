package com.vmanenkov.impl.user;

import com.vmanenkov.addressbook.data.UserRepository;
import com.vmanenkov.addressbook.model.user.Role;
import com.vmanenkov.addressbook.model.user.User;
import com.vmanenkov.services.user.UserService;

import javax.inject.Inject;
import java.util.Set;

public class UserServiceImpl implements UserService {
    @Inject
    private UserRepository userRepository;

    @Override
    public Set<User> getUsersByRole(Role role) {
        return userRepository.findUsersByRole(role);
    }
}
