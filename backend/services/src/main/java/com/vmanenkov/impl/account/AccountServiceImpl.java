package com.vmanenkov.impl.account;

import com.vmanenkov.addressbook.data.account.AccountRepository;
import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;
import com.vmanenkov.services.account.AccountService;
import com.vmanenkov.services.exceptions.AccountNotFoundException;
import com.vmanenkov.services.exceptions.AccountNotValidException;
import com.vmanenkov.services.exceptions.EmailNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AccountErrorType;
import com.vmanenkov.services.exceptions.errortypes.EmailErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;
import java.util.HashSet;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountRepository accountRepository;

    @Override
    public Collection<Account> getAccountsByRole(Role role) {
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

    @Override
    public Account create(String email, String password) throws AccountNotValidException, EmailNotValidException {

        validateEmail(email);

        if (accountRepository.findOptionalByEmail(email) != null) {
            throw new EmailNotValidException(EmailErrorType.EMAIL_IS_NOT_UNIQUE);
        }

        validatePassword(password);

        Account account = new Account(email, password);
        accountRepository.save(account);
        return account;
    }

    private void validatePassword(String password) throws AccountNotValidException {
        if (password == null || password.isEmpty()) {
            throw new AccountNotValidException(AccountErrorType.PASSWORD_IS_EMPTY);
        }

        // todo: add validate
    }

    private void validateEmail(String email) throws AccountNotValidException, EmailNotValidException {
        if (email == null || email.isEmpty()) {
            throw new EmailNotValidException(EmailErrorType.EMAIL_IS_EMPTY);
        }

        String regex = "^[-a-z0-9!#$%&*+/=?^_`{|}~]+(.[-a-z0-9!#$%&*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";
        //String regex = "^[a-z0-9]+@[a-z0-9]+.com$";
        if (!email.toLowerCase().matches(regex)) {
            throw new EmailNotValidException(EmailErrorType.EMAIL_IS_NOT_VALID);
        }
    }

    @Override
    public Account updateEmail(Long accountId, String email) throws AccountNotValidException, AccountNotFoundException, EmailNotValidException {
        validateEmail(email);
        Account account = getById(accountId);
        account.setEmail(email);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account addRole(Long accountId, Role role) throws AccountNotFoundException {
        Account account = getById(accountId);
        account.getRoles().add(role);
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account removeRole(Long accountId, Role role) throws AccountNotFoundException {
        Account account = getById(accountId);
        account.getRoles().remove(role);
        accountRepository.save(account);
        return account;
    }

    @Override
    public void delete(Long id) throws AccountNotFoundException {
        accountRepository.remove(getById(id));
    }

    @Override
    public Collection<Account> getAll() {
        return accountRepository.findAll();
    }
}
