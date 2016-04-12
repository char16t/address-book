package com.vmanenkov.services.account;

import com.vmanenkov.addressbook.model.DbEntity;
import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;

import javax.ejb.Local;
import javax.security.auth.login.AccountNotFoundException;
import java.util.Collection;
import java.util.Set;

@Local
public interface AccountService {

    Account getById(Long id) throws AccountNotFoundException;

    Account create(String email, String password);

    Account get(Long id);

    Account update(Account id, String email, String password);

    Account addRole(Account account, Role role);

    Account removeRole(Account account, Role role);

    void delete(Long id);

    Collection<Account> getAll();

    Collection<Account> getAccountsByRole(Role role);
}
