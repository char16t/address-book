package com.vmanenkov.impl.user;

import com.vmanenkov.addressbook.data.RoleRepository;
import com.vmanenkov.addressbook.model.user.Role;
import com.vmanenkov.services.exceptions.UserRoleNotFoundException;
import com.vmanenkov.services.user.RoleService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RoleServiceImpl implements RoleService {
    @Inject
    private RoleRepository roleRepository;

    @Override
    public Role getByName(String name) throws UserRoleNotFoundException {
        Role role = roleRepository.getByName(name);
        if(role == null) {
            throw new UserRoleNotFoundException();
        }
        return role;
    }
}
