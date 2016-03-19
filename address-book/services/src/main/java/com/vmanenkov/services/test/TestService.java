package com.vmanenkov.services.test;

import com.vmanenkov.addressbook.model.test.Test;
import com.vmanenkov.services.exceptions.TestDisabledException;

import javax.ejb.Local;

@Local
public interface TestService {
    Test get() throws TestDisabledException;

    Test insert(String description) throws TestDisabledException;

    Test update(Test test, String description) throws TestDisabledException;

}
