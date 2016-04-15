package com.vmanenkov.addressbook.data.test;

import com.vmanenkov.addressbook.model.test.Test;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.SingleResultType;

@Repository
public interface TestRepository extends EntityRepository<Test, Long> {

	Test findOptionalById(Integer id);

	@Query(value = "select p from Test p", max = 1, singleResult = SingleResultType.OPTIONAL)
	Test findFirst();

}
