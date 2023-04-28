package br.com.fit.petsInfo.adapter.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsInfo.adapter.entity.PetsListEntity;
import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.adapter.mapper.EntityMapper;
import br.com.fit.petsInfo.application.dto.PetsList;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;

@Component
public class UserInfoResponseMapper implements EntityMapper<UserInfoEntity>{

	
	public UserInfoResponse entityToResponse(UserInfoEntity entity) {
		return this.mapping(entity);
	}
	
	public List<UserInfoResponse> entityListToResponse(List<UserInfoEntity> entity) {
		
		List<UserInfoResponse> listUserResponse = new ArrayList<>();
		
		for (UserInfoEntity userInfoEntity : entity) {
			listUserResponse.add(this.mapping(userInfoEntity));
		}
		
		return listUserResponse;
	}
	
	@Override
	public UserInfoResponse mapping(UserInfoEntity entity) {
		UserInfoResponse reponse = new UserInfoResponse().
				builder()
				.id(entity.getId())
				.username(entity.getUsername())
				.cpf(entity.getCpf())
				.address(entity.getAddress())
				.registrationDate(entity.getRegistrationDate())
				.petsList(this.toPetsListResponse(entity.getPetsList()))
				.build();
		
		return reponse;
	}

	private List<PetsList> toPetsListResponse(List<PetsListEntity> petsList) {
		List<PetsList> listPetsResponse = new ArrayList<>();

		for (PetsListEntity pet : petsList) {
			var petObj = new PetsList().builder()
					.id(pet.getId())
					.petName(pet.getPetName())
					.rating(pet.getRating())
					.animalType(pet.getAnimalType())
					.status(pet.getStatus())
					.build();
			
			listPetsResponse.add(petObj);
		}
		
		return listPetsResponse;
	}


	@Override
	public UserInfoEntity unmapping(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
