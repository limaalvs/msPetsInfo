package br.com.fit.petsInfo.adapter.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsInfo.adapter.mapper.impl.UserInfoResponseMapper;
import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.application.port.out.FindUsersInfosPortOut;

@Component
public class FindUsersInfosAdapterOut implements FindUsersInfosPortOut{
	
	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
	private UserInfoResponseMapper responseMapper;
	
	@Override
	public UserInfoResponse findUserById(Long id) {
		return responseMapper.entityToResponse(repository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User id not found in database")));		
	}

	@Override
	public List<UserInfoResponse> findAllUsers() {
		var response = responseMapper.entityListToResponse(repository.findAll());
		
		if (response.isEmpty()) {			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Any Users found in database");
		}
		return response; 
		
	}

}
