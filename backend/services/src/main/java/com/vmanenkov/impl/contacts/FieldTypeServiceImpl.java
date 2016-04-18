package com.vmanenkov.impl.contacts;

import com.vmanenkov.addressbook.data.contacts.FieldTypeRepository;
import com.vmanenkov.addressbook.model.contacts.FieldType;
import com.vmanenkov.services.contacts.FieldTypeService;
import com.vmanenkov.services.exceptions.FieldTypeNotFoundException;
import com.vmanenkov.services.exceptions.FieldTypeNotValidException;
import com.vmanenkov.services.exceptions.errortypes.FieldTypeErrorType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class FieldTypeServiceImpl implements FieldTypeService {

    @Inject
    private FieldTypeRepository fieldTypeRepository;

    @Override
    public FieldType create(String typeName) throws FieldTypeNotValidException {
        if (typeName == null || "".equals(typeName)) {
            throw new FieldTypeNotValidException(FieldTypeErrorType.FIELD_TYPE_NAME_IS_EMPTY);
        }
        if (getByName(typeName) != null) {
            throw new FieldTypeNotValidException(FieldTypeErrorType.FIELD_TYPE_NAME_IS_NOT_UNIQUE);
        }

        FieldType fieldType = new FieldType(typeName);
        return fieldTypeRepository.save(fieldType);
    }

    @Override
    public FieldType get(Long id) throws FieldTypeNotFoundException {
        FieldType fieldType = fieldTypeRepository.findOptionalById(id);
        if (fieldType == null) {
            throw new FieldTypeNotFoundException();
        }
        return fieldType;
    }

    @Override
    public FieldType update(Long id, String typeName) throws FieldTypeNotFoundException, FieldTypeNotValidException {
        FieldType fieldType = get(id);

        if (typeName != null || !("".equals(typeName))) {
            fieldType.setTypeName(typeName);
        }

        return fieldTypeRepository.save(fieldType);
    }

    @Override
    public FieldType getByName(String name) {
        return fieldTypeRepository.findOptionalByTypeName(name);
    }

    @Override
    public void delete(Long id) throws FieldTypeNotFoundException {
        FieldType fieldType = get(id);
        fieldTypeRepository.remove(fieldType);
    }

    @Override
    public Collection<FieldType> getAll() {
        return fieldTypeRepository.findAll();
    }
}
