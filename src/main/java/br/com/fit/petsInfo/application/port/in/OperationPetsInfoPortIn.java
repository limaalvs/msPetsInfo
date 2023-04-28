package br.com.fit.petsInfo.application.port.in;

import java.util.List;

import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;

public interface OperationPetsInfoPortIn {
	UserInfoResponse createUser(UserInfoRequest request);
	UserInfoResponse findUserById(Long id); 
	UserInfoResponse updatePetsListByUserName(Long id, UserInfoRequest request);
	List<UserInfoResponse> findAllUsers();
	void deleteUserInfo(Long id);
}
