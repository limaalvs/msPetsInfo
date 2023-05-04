package br.com.fit.petsInfo.adapter.out;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoResponseMapper;
import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoUpdateObjMapper;
import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoEntityFactory;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoRequestFactory;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoResponseFactory;

@ExtendWith(SpringExtension.class)
public class UpdateUsersInfoTest {

	@InjectMocks
	UpdateUsersInfo updateUsersInfo;
	
	@Mock
	private UserInfoRepository repository;
	
	@Mock
	private UserInfoUpdateObjMapper mapper; 
	
	@Mock
	private UserInfoResponseMapper responseMapper;
	
	private UserInfoRequest request;
	private UserInfoResponse response;
	private Optional<UserInfoEntity> entity; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = UserInfoRequestFactory.buildRequestMock();
		response = UserInfoResponseFactory.buildResponseMock();
		entity = Optional.of(UserInfoEntityFactory.buildEntityMock());
	}
	
	
	
	@Test
	void shoulUpdateEntityWithSucess() {
		
		doReturn(entity).when(repository).findById(any());
		doNothing().when(mapper).userInfoRequestToEntity(request, entity.get());
		doReturn(response).when(responseMapper).entityToResponse(any());
		
		Assertions.assertDoesNotThrow(() -> {			
			updateUsersInfo.updatePetsListByUserName(1L, request);
		});
	}
	
	
	@Test
	void shouldNotFindUserByInvalidId() {
		assertThrows(ResponseStatusException.class, () -> {
			updateUsersInfo.updatePetsListByUserName(1L, request);
		});
	}
	
	@Test
	void shouldNotFindUserByInvalidIdEntityNull() {
		Optional<UserInfoEntity> entiyObj = Optional.of(new UserInfoEntity());
		
		doReturn(entiyObj).when(repository).findById(any());
		doReturn(response).when(responseMapper).entityToResponse(any());
		
		Assertions.assertDoesNotThrow(() -> {			
			updateUsersInfo.updatePetsListByUserName(1L, request);
		});
	}
	
}
