package br.com.fit.petsInfo.adapters.input.controller.mapper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsInfo.adapters.input.controller.mapper.MapperController;
import br.com.fit.petsInfo.domain.model.PetsList;
import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.PetsListRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.TutorRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.PetsListResponse;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.TutorResponse;

@Component
public class PetInfoControllerMapper implements MapperController{

	@Override
	public Tutor toUserInfoRecord (TutorRequest request) {
		
		Tutor record = new Tutor().builder()
				.username(request.getUsername())
				.cpf(request.getCpf())
				.address(request.getAddress())
				.registrationDate(new Date().toString())
				.petsList(this.toPetsListRecord(request.getPetsList()))
				.build();
	
		return record; 
	}
	
	private List<PetsList> toPetsListRecord(List<PetsListRequest> petsList) {
		List<PetsList> listPets = new ArrayList<>();
		
		for (PetsListRequest pet : petsList) {
			var petObj = new PetsList().builder()
					.id(pet.getId())
					.petName(pet.getPetName())
					.rating(pet.getRating())
					.animalType(pet.getAnimalType())
					.status(pet.getStatus())
					.build();
			
			listPets.add(petObj);
		}
		
		return listPets;		
	}
	
	@Override
	public TutorResponse toResponsePetInfo (Tutor record) {
		
		TutorResponse response = new TutorResponse().builder()
				.id(record.getId())
				.username(record.getUsername())
				.cpf(record.getCpf())
				.address(record.getAddress())
				.registrationDate(record.getRegistrationDate())
				.petsList(this.toPetsListResponse(record.getPetsList()))
				.build();
		
		
		return response; 
	}
	
	private List<PetsListResponse> toPetsListResponse(List<PetsList> petsList) {
		List<PetsListResponse> listPetsResponse = new ArrayList<>();
		
		for (PetsList pet : petsList) {
			var petObj = new PetsListResponse().builder()
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
	public List<TutorResponse> toListResponsePetInfo(List<Tutor> record) {
		List<TutorResponse> listResponse = new ArrayList<>();
		
		for (Tutor userInfo : record) {
			listResponse.add(this.toResponsePetInfo(userInfo));
		}

		return listResponse; 
	}

}
