package com.vmanenkov.impl;

import com.vmanenkov.addressbook.data.TestRepository;
import com.vmanenkov.addressbook.model.test.Test;
import com.vmanenkov.addressbook.util.LoggerAB;
import com.vmanenkov.services.exceptions.TestDisabledException;
import com.vmanenkov.services.test.TestService;
import com.vmanenkov.services.util.ServicesConf;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TestServiceImpl implements TestService {

    @Inject
    private LoggerAB log;

    @Inject
    private TestRepository testRepository;

    @Inject
    private ServicesConf servicesConf;

    @Override
    public Test get() throws TestDisabledException {
        isTestEnabled();

        return testRepository.findFirst();
    }

    @Override
    public Test insert(String description) throws TestDisabledException {
        isTestEnabled();

        log.fine("insert()");

        Test entity = new Test();
        entity.setDescription(description);
        testRepository.save(entity);
        return entity;
    }

    @Override
    public Test update(Test test, String description) throws TestDisabledException {
        isTestEnabled();

        log.fine("update({0})", test, description);

        test.setDescription(description);
        testRepository.save(test);
        return test;
    }

    private void isTestEnabled() throws TestDisabledException {
        if (!servicesConf.isTestEnabled())
            throw new TestDisabledException();
    }


}
