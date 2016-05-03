package com.vmanenkov.addressbook.utils;

import com.vmanenkov.addressbook.model.DbEntity;
import com.vmanenkov.addressbook.model.account.*;
import com.vmanenkov.addressbook.model.contacts.*;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.account.*;
import com.vmanenkov.addressbook.rest.model.contacts.*;
import com.vmanenkov.addressbook.rest.services.EntityConverter;

import javax.ejb.Stateless;
import java.lang.reflect.Field;
import java.util.*;

@Stateless
public class EntityConverterImpl implements EntityConverter {

    public static final Map<Class, Class> CLASSES;

    static {
        Map<Class, Class> classMap = new HashMap<>();
        classMap.put(Account.class, AccountRest.class);
        classMap.put(Role.class, RoleRest.class);
        classMap.put(Attribute.class, AttributeRest.class);
        classMap.put(AttributeGroup.class, AttributeGroupRest.class);
        classMap.put(AttributeType.class, AttributeTypeRest.class);
        classMap.put(AttributeValue.class, AttributeValueRest.class);
        classMap.put(FieldType.class, FieldTypeRest.class);
        classMap.put(Note.class, NoteRest.class);
        classMap.put(Person.class, PersonRest.class);
        classMap.put(Tag.class, TagRest.class);
        classMap.put(AttributeList.class, AttributeListRest.class);

        CLASSES = Collections.unmodifiableMap(classMap);
    }


    @Override
    public RestEntity convertToRest(DbEntity model) {

        RestEntity restEntity = null;


        try {
            if (model == null) {
                return null;
            }

            Class dbClass = model.getClass();
            Class restClass = CLASSES.get(dbClass);
            restEntity = (RestEntity) restClass.newInstance();
            for (Field field : dbClass.getDeclaredFields()) {
                field.setAccessible(true);
                String fieldName = field.getName();

                Field fieldRest = null;
                for (Field f : restClass.getDeclaredFields()) {
                    if (f.getName().equals(fieldName)) {
                        fieldRest = f;
                    }
                }
                Class type = field.getType();
                if (fieldRest == null) {
                    continue;
                }

                fieldRest.setAccessible(true);

                List<Class> interfaces = Arrays.asList(type.getInterfaces());

                if (interfaces.contains(DbEntity.class)) {
                    RestEntity restFieldValue = this.convertToRest((DbEntity) field.get(model));
                    fieldRest.set(restEntity, restFieldValue);
                }
                else if (interfaces.contains(Collection.class)) {
                    Collection<DbEntity> dbValues = (Collection) field.get(model);
                    if (dbValues == null) {
                        continue;
                    }

                    Collection<RestEntity> restValues = new HashSet<>(dbValues.size());
                    for (DbEntity dbValue : dbValues) {
                        restValues.add(this.convertToRest(dbValue));
                    }
                    fieldRest.set(restEntity, restValues);
                }
                else {
                    fieldRest.set(restEntity, field.get(model));
                }
            }

        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return restEntity;
    }

    @Override
    public Collection<RestEntity> convertAllToRest(Collection<DbEntity> models) {
        Collection<RestEntity> restEntities = new HashSet<>(models.size());
        for (DbEntity model : models) {
            restEntities.add(convertToRest(model));
        }
        return restEntities;
    }

    @Override
    public DbEntity convertToDb(RestEntity model) {
        return null;
    }

}
