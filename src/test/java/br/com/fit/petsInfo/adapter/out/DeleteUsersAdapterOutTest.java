package br.com.fit.petsInfo.adapter.out;

import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

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
import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoEntityFactory;

@ExtendWith(SpringExtension.class)
public class DeleteUsersAdapterOutTest {

	@InjectMocks
	DeleteUsersAdapterOut deleteUsersAdapterOut;

	@Mock
	UserInfoRepository repository;

	private Optional<UserInfoEntity> entity; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		entity = Optional.of(UserInfoEntityFactory.buildEntityMock());
	}

	@Test
	void shouldDeleteUserByIdInfosWithSucess() {
		doReturn(entity).when(repository).findById(any());
		Assertions.assertDoesNotThrow(() -> {
			deleteUsersAdapterOut.deleteUserInfo(1L);
		});
	}
	
	
	@Test
	void shouldNotDeleteUserInfosByInvalidId() {
		assertThrows(ResponseStatusException.class, () -> {
			deleteUsersAdapterOut.deleteUserInfo(3L);
		});
	}
}
