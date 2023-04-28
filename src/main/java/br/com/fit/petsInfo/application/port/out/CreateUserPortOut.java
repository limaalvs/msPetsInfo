package br.com.fit.petsInfo.application.port.out;

import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;

public interface CreateUserPortOut {
	UserInfoResponse createUser(UserInfoRequest request);
}
