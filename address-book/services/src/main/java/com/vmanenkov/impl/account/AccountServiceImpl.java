package com.vmanenkov.impl.account;

import com.vmanenkov.addressbook.data.account.AccountRepository;
import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.services.account.AccountService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.security.auth.login.AccountNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AccountServiceImpl implements AccountService {
    @Inject
    private AccountRepository accountRepository;

    @Override
    public Set<Account> getAccountsByRole(Role role) {
        return new HashSet<>(accountRepository.findAccountsByRole(role.getName()));
    }

    @Override
    public Account getById(Long id) throws AccountNotFoundException {
        Account account = accountRepository.findOptionalById(id);
        if (account == null) {
            throw new AccountNotFoundException();
        }

        return account;
    }
}
