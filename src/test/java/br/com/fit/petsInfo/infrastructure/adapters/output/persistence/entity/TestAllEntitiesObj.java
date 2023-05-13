package br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllEntitiesObj {

	@Test
	void testeAllEntityObjs() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(TutorEntity.class);
		beanTester.testBean(PetsListEntity.class);
	}
}
