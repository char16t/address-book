package com.vmanenkov.impl.account;

import com.vmanenkov.services.account.PermissionService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PermissionServiceImpl implements PermissionService {

}
