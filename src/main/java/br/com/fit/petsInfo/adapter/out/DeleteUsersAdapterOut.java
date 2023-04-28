package br.com.fit.petsInfo.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsInfo.adapter.repository.UserInfoRepository;
import br.com.fit.petsInfo.application.port.out.DeleteUserInfoPortOut;

@Component
public class DeleteUsersAdapterOut implements DeleteUserInfoPortOut{

	@Autowired
	private UserInfoRepository repository;
	
	
	@Override
	public void deleteUserInfo(Long id) {		
		repository.findById(id).map( userRegister -> {
			repository.delete(userRegister);
			return Void.TYPE;
		}).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User id not found in database"));
		
	}

}
