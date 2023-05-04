package br.com.fit.petsInfo.adapter.mapper.impl;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoEntityFactory;

@ExtendWith(SpringExtension.class)
public class UserInfoResponseMapperTest {
	
	@InjectMocks
	UserInfoResponseMapper userInfoResponseMapper;
	
	private UserInfoEntity entity; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		entity = UserInfoEntityFactory.buildEntityMock();
	}
	
	
	@Test 
	void shouldConvertoEntityToResponse() {
		Assertions.assertDoesNotThrow(() -> {
			var response = userInfoResponseMapper.entityToResponse(entity);
			
			Assertions.assertNotNull(response);
			Assertions.assertEquals(entity.getUsername(), response.getUsername());
		});
	}
	
	@Test
	void shouldUnmapping() {
		Assertions.assertDoesNotThrow(() -> {
			var entityObj = userInfoResponseMapper.unmapping(entity);
			
			Assertions.assertEquals(entityObj, null);
		});
	}
	
	@Test 
	void shouldConvertoEntityToResponseList() {
		var entityList = new ArrayList<UserInfoEntity>();
		entityList.add(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			var response = userInfoResponseMapper.entityListToResponse(entityList);
			
			Assertions.assertNotNull(response);
			Assertions.assertEquals(entityList.get(0).getUsername(), response.get(0).getUsername());
		});
	}
}
