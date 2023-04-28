package br.com.fit.petsInfo.adapter.out;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoResponseMapper;
import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoUpdateObjMapper;
import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.application.port.out.UpdateUserPortOut;

@Component
public class UpdateUsersInfo implements UpdateUserPortOut{

	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
	private UserInfoUpdateObjMapper mapper; 
	
	@Autowired
	private UserInfoResponseMapper responseMapper;
	
	@Override
	public UserInfoResponse updatePetsListByUserName(Long id, UserInfoRequest request) {
		UserInfoEntity entity = repository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User id not found in database"));

		if (Objects.nonNull(entity)) {
			mapper.userInfoRequestToEntity(request, entity);
		} 
		return responseMapper.entityToResponse(repository.save(entity));

	}
	
	
}
