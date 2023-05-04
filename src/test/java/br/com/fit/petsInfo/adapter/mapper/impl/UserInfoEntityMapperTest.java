package br.com.fit.petsInfo.adapter.mapper.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoRequestFactory;

@ExtendWith(SpringExtension.class)
public class UserInfoEntityMapperTest {
	
	
	@InjectMocks
	UserInfoEntityMapper userInfoEntityMapper;
	
	private UserInfoRequest request;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = UserInfoRequestFactory.buildRequestMock();
	}
	
	@Test 
	void shouldConvertRequetsToEntityWithSucess() {
		Assertions.assertDoesNotThrow(() -> {
			var entityObj = userInfoEntityMapper.userInfoRequestToEntity(request);
			
			Assertions.assertNotNull(entityObj);
			Assertions.assertEquals(entityObj.getUsername(), request.getUsername());
		});
	}

	@Test
	void shouldUnmapping() {
		Assertions.assertDoesNotThrow(() -> {
			var entityObj = userInfoEntityMapper.unmapping(request);
			
			Assertions.assertEquals(entityObj, null);
		});
	}
	
}

