package com.vmanenkov.addressbook.data.user;


import com.vmanenkov.addressbook.model.user.Account;
import org.apache.deltaspike.data.api.EntityRepository;

public interface AccountRepository extends EntityRepository<Account, Long> {

}
