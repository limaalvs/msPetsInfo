package br.com.fit.petsInfo.application.port.out;

import java.util.List;

import br.com.fit.petsInfo.application.dto.UserInfoResponse;

public interface FindUsersInfosPortOut {
	UserInfoResponse findUserById(Long id);
	List<UserInfoResponse> findAllUsers();
}
