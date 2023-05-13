package br.com.fit.petsInfo.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllRecordsTest {

	@Test
	void testeAllRequestsObjs() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(Tutor.class);
		beanTester.testBean(PetsList.class);
	}
}
