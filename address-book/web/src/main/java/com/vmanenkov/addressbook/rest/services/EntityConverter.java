package com.vmanenkov.addressbook.rest.services;

import com.vmanenkov.addressbook.model.DbEntity;
import com.vmanenkov.addressbook.rest.model.RestEntity;

import javax.ejb.Local;

@Local
public interface EntityConverter {
    RestEntity convertToRest(DbEntity model);

    DbEntity convertToDb(RestEntity model);

}
