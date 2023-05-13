package br.com.fit.petsInfo.infrastructure.adapters.input.controller.request;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllRequestsObj {
	
	@Test
	void testeAllRequestsObjs() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(TutorRequest.class);
		beanTester.testBean(PetsListRequest.class);
	}
}
