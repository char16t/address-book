package com.vmanenkov.services.account;

import com.vmanenkov.addressbook.model.account.Account;
import com.vmanenkov.addressbook.model.account.Role;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface  AccountService {

    Set<Account> getAccountsByRole(Role role);

}
