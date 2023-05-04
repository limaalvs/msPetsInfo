package br.com.fit.petsInfo.application.core.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.application.port.out.CreateUserPortOut;
import br.com.fit.petsInfo.application.port.out.DeleteUserInfoPortOut;
import br.com.fit.petsInfo.application.port.out.FindUsersInfosPortOut;
import br.com.fit.petsInfo.application.port.out.UpdateUserPortOut;

@ExtendWith(SpringExtension.class)
public class PetsInfosServiceImplTest {

	@InjectMocks
	PetsInfosServiceImpl petsInfosServiceImpl;
	
	@Mock
	CreateUserPortOut createtOut; 
	
	@Mock
	FindUsersInfosPortOut findPortOut; 
	
	@Mock
	DeleteUserInfoPortOut deletePortOut;
	
	@Mock
	UpdateUserPortOut updatePortOut;
	
	
	@Test
	void whenCreateUserIsCallVerify() {
		petsInfosServiceImpl.createUser(any());
		Mockito.verify(createtOut, Mockito.times(1)).createUser(any());
	}
	
	@Test
	void whenFindUserByIdIsCallVerify() {
		petsInfosServiceImpl.findUserById(any());
		Mockito.verify(findPortOut, Mockito.times(1)).findUserById(any());
	}
	
	@Test
	void whenFindAllUsersIsCallVerify() {
		petsInfosServiceImpl.findAllUsers();
		Mockito.verify(findPortOut, Mockito.times(1)).findAllUsers();
	}
	
	@Test
	void whenDeleteUserByIdIsCallVerify() {
		petsInfosServiceImpl.deleteUserInfo(any());
		Mockito.verify(deletePortOut, Mockito.times(1)).deleteUserInfo(any());
	}
	
	@Test
	void whenUpdateByIdIsCallVerify() {
		petsInfosServiceImpl.updatePetsListByUserName(any(), any());
		Mockito.verify(updatePortOut, Mockito.times(1)).updatePetsListByUserName(any(), any());
	}
}
