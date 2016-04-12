package com.vmanenkov.services.account;

import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.services.exceptions.AccountNotFoundException;
import com.vmanenkov.services.exceptions.AccountNotValidException;
import com.vmanenkov.services.exceptions.EmailNotValidException;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface AccountService {

    Account getById(Long id) throws AccountNotFoundException;

    Account create(String email, String password) throws AccountNotValidException, EmailNotValidException;

    Account updateEmail(Long accountId, String email) throws AccountNotValidException, AccountNotFoundException, EmailNotValidException;

    Account addRole(Long accountId, Role role) throws AccountNotFoundException;

    Account removeRole(Long accountId, Role role) throws AccountNotFoundException;

    void delete(Long id) throws AccountNotFoundException;

    Collection<Account> getAll();

    Collection<Account> getAccountsByRole(Role role);
}
