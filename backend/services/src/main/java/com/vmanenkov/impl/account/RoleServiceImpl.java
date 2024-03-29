package com.vmanenkov.impl.account;

import com.vmanenkov.addressbook.data.account.RoleRepository;
import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.services.exceptions.UserRoleNotFoundException;
import com.vmanenkov.services.account.RoleService;

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
        Role role = roleRepository.findOptionalByName(name);
        if (role == null) {
            throw new UserRoleNotFoundException();
        }
        return role;
    }

    @Override
    public Role getById(Long id) throws UserRoleNotFoundException {
        Role role = roleRepository.findOptionalById(id);
        if (role == null) {
            throw new UserRoleNotFoundException();
        }
        return role;
    }
}
