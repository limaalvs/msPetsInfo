package br.com.fit.petsInfo.adapter.out;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoEntityMapper;
import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoResponseMapper;
import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoRequestFactory;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoResponseFactory;

@ExtendWith(SpringExtension.class)
public class CreateUserInfoAdapterOutTest {

	@InjectMocks
	CreateUserInfoAdapterOut createUserInfoAdapterOut;
	
	@Mock
	UserInfoRepository repository;
	
	@Mock
	UserInfoEntityMapper entityMapper;
	
	@Mock
	UserInfoResponseMapper responseMapper;

	private UserInfoRequest request;
	private UserInfoResponse response;
	private UserInfoEntity entity; 
	

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = UserInfoRequestFactory.buildRequestMock();
		response = UserInfoResponseFactory.buildResponseMock();
	}
	
	@Test
	void shouldCreateUserWithSucess() {
		
		doReturn(entity).when(repository).save(any());
		doReturn(entity).when(entityMapper).userInfoRequestToEntity(request);
		doReturn(response).when(responseMapper).entityToResponse(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			var responseCreate = createUserInfoAdapterOut.createUser(request);
			Assertions.assertNotNull(responseCreate);
		});
	}
	
}
