package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.AttributeGroupRepository;
import com.vmanenkov.addressbook.model.contacts.AttributeGroup;
import com.vmanenkov.services.contacts.AttributeGroupService;
import com.vmanenkov.services.exceptions.AttributeGroupNotFoundException;
import com.vmanenkov.services.exceptions.AttributeGroupNotValidException;
import com.vmanenkov.services.exceptions.errortypes.AttributeGroupErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AttributeGroupServiceImpl implements AttributeGroupService {

    @Inject
    private AttributeGroupRepository attributeGroupRepository;

    @Override
    public AttributeGroup create(String name, String description) throws AttributeGroupNotValidException {
        if (name == null || "".equals(name)) {
            throw new AttributeGroupNotValidException(AttributeGroupErrorType.ATTRIBUTE_GROUP_NAME_IS_EMPTY);
        }

        AttributeGroup attributeGroup = new AttributeGroup(name, description);
        return attributeGroupRepository.save(attributeGroup);
    }

    @Override
    public AttributeGroup get(Long id) throws AttributeGroupNotFoundException {
        AttributeGroup attributeGroup = attributeGroupRepository.findBy(id);
        if (attributeGroup == null) {
            throw new AttributeGroupNotFoundException();
        }
        return attributeGroup;
    }

    @Override
    public AttributeGroup update(Long id, String name,
                                 String description)
            throws AttributeGroupNotFoundException, AttributeGroupNotValidException {
        AttributeGroup attributeGroup = get(id);
        if (name != null) {
            if ("".equals(name)) {
                throw new AttributeGroupNotValidException(AttributeGroupErrorType.ATTRIBUTE_GROUP_NAME_IS_EMPTY);
            }
            attributeGroup.setName(name);
        }
        if (description != null) {
            attributeGroup.setDescription(description);
        }
        return attributeGroupRepository.save(attributeGroup);
    }

    @Override
    public void delete(Long id) throws AttributeGroupNotFoundException {
        AttributeGroup attributeGroup = get(id);
        attributeGroupRepository.remove(attributeGroup);
    }

}
