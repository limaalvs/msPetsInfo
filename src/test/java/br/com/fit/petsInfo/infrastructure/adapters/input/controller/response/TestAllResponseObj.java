package br.com.fit.petsInfo.infrastructure.adapters.input.controller.response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestAllResponseObj {

	
	@Test
	void testeAllResponseObjs() {
		BeanTester beanTester = new BeanTester(); 
		beanTester.testBean(TutorResponse.class);
		beanTester.testBean(PetsListResponse.class);
	}
}

