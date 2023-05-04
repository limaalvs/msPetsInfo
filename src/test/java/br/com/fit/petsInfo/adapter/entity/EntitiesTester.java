package br.com.fit.petsInfo.adapter.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EntitiesTester {
	
	
	@Test
	void testAllEntitie(){
		BeanTester beanTester = new BeanTester(); 
		beanTester.testBean(PetsListEntity.class);
		beanTester.testBean(UserInfoEntity.class);
	}

}
