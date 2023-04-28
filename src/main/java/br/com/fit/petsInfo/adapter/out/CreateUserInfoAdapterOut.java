package br.com.fit.petsInfo.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoEntityMapper;
import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoResponseMapper;
import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.application.port.out.CreateUserPortOut;

@Component
public class CreateUserInfoAdapterOut implements CreateUserPortOut {

	@Autowired
	private UserInfoEntityMapper entityMapper;

	@Autowired
	private UserInfoResponseMapper responseMapper;

	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserInfoResponse createUser(UserInfoRequest request) {
		var entityObj = entityMapper.userInfoRequestToEntity(request);
		return responseMapper.entityToResponse(repository.save(entityObj));
	}

}
