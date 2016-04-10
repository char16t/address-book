package com.vmanenkov.addressbook.rest.services;

import com.vmanenkov.addressbook.model.DbEntity;
import com.vmanenkov.addressbook.rest.model.RestEntity;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface EntityConverter {
    RestEntity convertToRest(DbEntity model);

    Collection<RestEntity> convertAllToRest(Collection<DbEntity> models);

    DbEntity convertToDb(RestEntity model);

}
