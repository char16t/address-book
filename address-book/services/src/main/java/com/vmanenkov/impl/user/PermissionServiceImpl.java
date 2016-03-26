package com.vmanenkov.impl.user;

import com.vmanenkov.services.user.PermissionService;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PermissionServiceImpl implements PermissionService {

}
