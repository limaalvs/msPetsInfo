package br.com.fit.petsInfo.application.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DTOTester {

	@Test
	void testeAllDTOs() {
		BeanTester beanTester = new BeanTester(); 
		beanTester.testBean(UserInfoRequest.class);
		beanTester.testBean(UserInfoResponse.class);
		beanTester.testBean(PetsList.class);
	}
}
