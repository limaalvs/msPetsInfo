package br.com.fit.petsInfo.application.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.application.port.in.OperationPetsInfoPortIn;
import br.com.fit.petsInfo.application.port.out.CreateUserPortOut;
import br.com.fit.petsInfo.application.port.out.DeleteUserInfoPortOut;
import br.com.fit.petsInfo.application.port.out.FindUsersInfosPortOut;
import br.com.fit.petsInfo.application.port.out.UpdateUserPortOut;

@Service
public class PetsInfosServiceImpl implements OperationPetsInfoPortIn {

	@Autowired
	CreateUserPortOut createtOut; 
	
	@Autowired
	FindUsersInfosPortOut findPortOut; 
	
	@Autowired 
	DeleteUserInfoPortOut deletePortOut;
	
	@Autowired 
	UpdateUserPortOut updatePortOut;
	
	
	@Override
	public UserInfoResponse createUser(UserInfoRequest request) {
		return createtOut.createUser(request);
	}

	@Override
	public UserInfoResponse findUserById(Long id) {
		return findPortOut.findUserById(id);
	}

	@Override
	public List<UserInfoResponse> findAllUsers() {
		return findPortOut.findAllUsers();
	}
	
	@Override
	public void deleteUserInfo(Long id) {
		deletePortOut.deleteUserInfo(id);
	}
	
	@Override
	public UserInfoResponse updatePetsListByUserName(Long id, UserInfoRequest request) {
		return updatePortOut.updatePetsListByUserName(id, request);
	}


}
