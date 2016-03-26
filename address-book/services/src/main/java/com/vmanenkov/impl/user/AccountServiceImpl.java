package com.vmanenkov.impl.user;

import com.vmanenkov.addressbook.data.account.AccountRepository;
import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.services.user.AccountService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Set;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AccountServiceImpl implements AccountService {
    @Inject
    private AccountRepository accountRepository;

    @Override
    public Set<Account> getAccountsByRole(Role role) {
        return accountRepository.findAccountsByRole(role);
    }
}
