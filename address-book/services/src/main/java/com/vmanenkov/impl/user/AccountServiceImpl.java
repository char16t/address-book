package com.vmanenkov.impl.user;

import com.vmanenkov.addressbook.data.user.AccountRepository;
import com.vmanenkov.addressbook.model.user.Account;
import com.vmanenkov.addressbook.model.user.Role;
import com.vmanenkov.services.user.AccountService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AccountServiceImpl implements AccountService {
    @Inject
    private AccountRepository accountRepository;

    @Override
    public Set<Account> getAccountsByRole(Role role) {
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        return accountRepository.findAccountsByRole(roles);
    }
}
