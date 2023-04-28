package br.com.fit.petsInfo.application.port.out;

import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;

public interface UpdateUserPortOut {
	UserInfoResponse updatePetsListByUserName(Long id, UserInfoRequest request);
}
