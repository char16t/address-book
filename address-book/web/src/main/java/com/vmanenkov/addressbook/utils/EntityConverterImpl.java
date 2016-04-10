package com.vmanenkov.addressbook.utils;

import com.vmanenkov.addressbook.model.DbEntity;
import com.vmanenkov.addressbook.model.contacts.Note;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.model.contacts.NoteRest;
import com.vmanenkov.addressbook.rest.services.EntityConverter;

import javax.ejb.Stateless;
import java.lang.reflect.Field;
import java.util.*;

@Stateless
public class EntityConverterImpl implements EntityConverter {

    public static final Map<Class, Class> CLASSES;

    static {
        Map<Class, Class> classMap = new HashMap<>();
        classMap.put(Note.class, NoteRest.class);

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
                // todo: тут надо перебрать все поля и установить значения в аналогичных полях такими же, как
                // todo: и в классе-модели (считаем, что в restEntity поля имеют такое же имя, как и в dbEntity).
                // todo: Если в классе-модели имеется поле, имеющее тип, унаследованный от DbEntity
                // todo: можно вызвать текущий метод рекурсивно.
                // todo: Чуть сложнее для полей, которые являются коллекциями, но принцип тот же
                field.setAccessible(true);
                String fieldName = field.getName();

                Field fieldRest = null;
                for (Field f : restClass.getDeclaredFields()) {
                    if(f.getName().equals(fieldName)) {
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
    public DbEntity convertToDb(RestEntity model) {
        return null;
    }

}
