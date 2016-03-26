package com.vmanenkov.services.user;

import com.vmanenkov.addressbook.model.user.Account;
import com.vmanenkov.addressbook.model.user.Role;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface  AccountService {

    Set<Account> getAccountsByRole(Role role);

}
