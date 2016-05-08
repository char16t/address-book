package com.vmanenkov.addressbook.data.contacts;

import com.vmanenkov.addressbook.model.contacts.AttributeListValue;

import java.util.List;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

@Repository
public interface AttributeListValueRepository extends EntityRepository<AttributeListValue, Long>{
    AttributeListValue findOptionalById(Long id);
    
    @Query(value = "" +
            "SELECT alv " +
            "  FROM AttributeListValue  alv " +
            "  JOIN alv.attributeList   al " +
            " WHERE al.id = ?1", singleResult = SingleResultType.OPTIONAL)
    List<AttributeListValue> findOptionalByAttributeListId(Long attributeListId);

    @Query(value = "" +
            "SELECT alv " +
            "  FROM AttributeListValue  alv " +
            "  JOIN alv.attributeList   al " +
            " WHERE al.id = ?1 and alv.value = ?2", singleResult = SingleResultType.OPTIONAL)
    AttributeListValue findOptionalByValueInList(Long listId, String value);

}
