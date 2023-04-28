package br.com.fit.petsInfo.adapter.mapper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsInfo.adapter.entity.PetsListEntity;
import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.adapter.mapper.EntityMapper;
import br.com.fit.petsInfo.application.dto.PetsList;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;

@Component
public class UserInfoEntityMapper implements EntityMapper<UserInfoRequest> {

	
	public UserInfoEntity userInfoRequestToEntity(UserInfoRequest request) {
		return this.mapping(request);
	}
	
	@Override
	public UserInfoEntity mapping(UserInfoRequest request) {
		UserInfoEntity entity = new UserInfoEntity().builder()
				.username(request.getUsername())
				.cpf(request.getCpf())
				.address(request.getAddress())
				.registrationDate(new Date().toString())
				.petsList(this.toPetsListEntity(request.getPetsList()))
				.build();
				
		
		
		return entity;
	}

	private List<PetsListEntity> toPetsListEntity(List<PetsList> petsList) {
		List<PetsListEntity> listPetsEntity = new ArrayList<>();
		
		for (PetsList pet : petsList) {
			var petEntity = new PetsListEntity()
					.builder()
					.petName(pet.getPetName())
					.rating(pet.getRating())
					.animalType(pet.getAnimalType())
					.status(pet.getStatus())
					.build();
			
			listPetsEntity.add(petEntity);
		}
		
		return listPetsEntity;
	}

	@Override
	public UserInfoRequest unmapping(Object obj) {
		return null;
	}

}
