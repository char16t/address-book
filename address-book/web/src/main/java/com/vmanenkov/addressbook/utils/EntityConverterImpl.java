package com.vmanenkov.addressbook.utils;

import com.vmanenkov.addressbook.model.DbEntity;
import com.vmanenkov.addressbook.rest.model.RestEntity;
import com.vmanenkov.addressbook.rest.services.EntityConverter;

import javax.ejb.Stateless;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Stateless
public class EntityConverterImpl implements EntityConverter {

    @Override
    public RestEntity convertToRest(DbEntity model) {

        RestEntity restEntity = null;

        try {
            Class dbClass = model.getClass();
            Class restClass = Class.forName(dbClass.getName() + "Rest");
            restEntity = (RestEntity) restClass.newInstance();
            for (Field field : dbClass.getDeclaredFields()) {
                // todo: тут надо перебрать все поля и установить значения в аналогичных полях такими же, как
                // todo: и в классе-модели (считаем, что в restEntity поля имеют такое же имя, как и в dbEntity).
                // todo: Если в классе-модели имеется поле, имеющее тип, унаследованный от DbEntity
                // todo: можно вызвать текущий метод рекурсивно.
                // todo: Чуть сложнее для полей, которые являются коллекциями, но принцип тот же
                field.setAccessible(true);
                String fieldName = field.getName();
                Class type = field.getType();
                Field fieldRest = restClass.getDeclaredField(fieldName);
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
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return restEntity;
    }

    @Override
    public DbEntity convertToDb(RestEntity model) {
        return null;
    }

}
