package br.com.fit.petsInfo.adapter.mapper.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoEntityFactory;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoRequestFactory;

@ExtendWith(SpringExtension.class)
public class UserInfoUpdateObjMapperTest {
	
	@InjectMocks
	UserInfoUpdateObjMapper userInfoUpdateObjMapper;
	
	private UserInfoRequest request; 
	private UserInfoEntity entity; 
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = UserInfoRequestFactory.buildRequestMock();
		entity = UserInfoEntityFactory.buildEntityMock();
	}
	
	@Test
	void shouldMapperRequestEntity() {
		Assertions.assertDoesNotThrow(() -> {
			userInfoUpdateObjMapper.userInfoRequestToEntity(request, entity);
			Assertions.assertNotNull(request);
			Assertions.assertNotNull(entity);
			Assertions.assertEquals(request.getUsername(), entity.getUsername());
		});
	}
	
	@Test
	void shouldMapperRequestEntityWithSucess() {
		request.setUsername("BatmanEhBruce");
		request.setAddress("Rua dos bobos, 78");
		request.getPetsList().get(0).setId(1L);
		request.getPetsList().get(0).setPetName("Bob");
		
		Assertions.assertDoesNotThrow(() -> {
			userInfoUpdateObjMapper.userInfoRequestToEntity(request, entity);
			Assertions.assertEquals("Bob", entity.getPetsList().get(0).getPetName());
			Assertions.assertEquals("BatmanEhBruce",entity.getUsername());
			Assertions.assertEquals("Rua dos bobos, 78", entity.getAddress());
		});
	}
}
