package br.com.fit.petsInfo.adapter.out;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
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
import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoEntityFactory;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoResponseFactory;

@ExtendWith(SpringExtension.class)
public class FindUsersInfosAdapterOutTest {
	
	@InjectMocks
	FindUsersInfosAdapterOut findUsersInfosAdapterOut;
	
	@Mock
	UserInfoRepository repository;
	
	@Mock
	UserInfoResponseMapper responseMapper;
	
	private Optional<UserInfoEntity> entity; 
	
	private UserInfoResponse response;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		entity = Optional.of(UserInfoEntityFactory.buildEntityMock());
		response = UserInfoResponseFactory.buildResponseMock();
	}
	
	@Test
	void shouldFindUserByIdWithSucess() {
		doReturn(entity).when(repository).findById(any());
		doReturn(response).when(responseMapper).entityToResponse(any());
		Assertions.assertDoesNotThrow(() -> {
			findUsersInfosAdapterOut.findUserById(1L);
		});
	}
	
	@Test
	void shouldNotFindUserByInvalidId() {
		assertThrows(ResponseStatusException.class, () -> {
			findUsersInfosAdapterOut.findUserById(5L);
		});
	}
	
	@Test
	void shouldFindAllUsersWithSucess() {
		var entityList = new ArrayList<UserInfoEntity>();
		var responseList = new ArrayList<UserInfoResponse>();
		
		entityList.add(entity.get());
		responseList.add(response);
		
		doReturn(entityList).when(repository).findAll();
		doReturn(responseList).when(responseMapper).entityListToResponse(any());
		
		Assertions.assertDoesNotThrow(() -> {
			var responseObj = findUsersInfosAdapterOut.findAllUsers();
			Assertions.assertNotNull(responseObj);
			Assertions.assertEquals(responseList.size(), responseObj.size());
		});
	}
	
	
	@Test
	void shouldNotFindAnyUsers() {
		var entityList = new ArrayList<UserInfoEntity>();
		var responseList = new ArrayList<UserInfoResponse>();
		
		entityList.add(entity.get());
		responseList.add(response);
		
		doReturn(entityList).when(repository).findAll();
		doReturn(new ArrayList<UserInfoResponse>()).when(responseMapper).entityListToResponse(any());
		
		assertThrows(ResponseStatusException.class, () -> {
			findUsersInfosAdapterOut.findAllUsers();
		});
	}
}
