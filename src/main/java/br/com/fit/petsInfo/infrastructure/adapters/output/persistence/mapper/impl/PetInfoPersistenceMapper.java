package br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsInfo.domain.model.PetsList;
import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.PetsListEntity;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.EntityMapper;

@Component
public class PetInfoPersistenceMapper implements EntityMapper {
	
	@Override
	public TutorEntity petInfoRecordToEntity(Tutor record) {
		return this.mapping(record);
	}
	
	private TutorEntity mapping(Tutor record) {
		TutorEntity entity = new TutorEntity().builder()
				.username(record.getUsername())
				.cpf(record.getCpf())
				.address(record.getAddress())
				.registrationDate(new Date().toString())
				.petsList(this.toPetsListEntity(record.getPetsList()))
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
	public Tutor entityToPetInfoRecord(TutorEntity entity) {
		return this.unmapping(entity);
	}
	
	@Override
	public List<Tutor> entityListToRecordList(List<TutorEntity> entity) {
		
		List<Tutor> listUserResponse = new ArrayList<>();
		
		for (TutorEntity userInfoEntity : entity) {
			listUserResponse.add(this.unmapping(userInfoEntity));
		}
		
		return listUserResponse;
	}
	
	public Tutor unmapping(TutorEntity entity) {
		Tutor reponse = new Tutor().
				builder()
				.id(entity.getId())
				.username(entity.getUsername())
				.cpf(entity.getCpf())
				.address(entity.getAddress())
				.registrationDate(entity.getRegistrationDate())
				.petsList(this.toPetsListRecord(entity.getPetsList()))
				.build();
		
		return reponse;
	}

	private List<PetsList> toPetsListRecord(List<PetsListEntity> petsList) {
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
	
}
