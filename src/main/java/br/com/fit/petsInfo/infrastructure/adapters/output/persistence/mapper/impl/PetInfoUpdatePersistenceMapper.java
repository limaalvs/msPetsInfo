package br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.domain.model.PetsList;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.PetsListEntity;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;

@Component
public class PetInfoUpdatePersistenceMapper {
	public void tutorToEntity(Tutor record, TutorEntity entity) {

		this.updateUsersInfo(record, entity);
		
		for (int i = 0; i < entity.getPetsList().size(); i++) {
			for (int j = 0; j < record.getPetsList().size() && !record.getPetsList().isEmpty(); j++) {
				if (this.isUpdateObj(entity.getPetsList().get(i), record.getPetsList().get(j))) { 
					// Atualiza PetsExistentes

					var entityObj = entity.getPetsList().get(i);
					var requestObj = record.getPetsList().get(j);

					// PET NAME
					entityObj.setPetName(requestObj.getPetName().equalsIgnoreCase(entityObj.getPetName()) ?
									entityObj.getPetName()
									: requestObj.getPetName());

					// RATING
					entityObj.setRating(requestObj.getRating() == entityObj.getRating() ? 
							entityObj.getRating()
							: requestObj.getRating());

					// ANIMAL TYPE
					entityObj.setAnimalType(requestObj.getAnimalType() == entityObj.getAnimalType() ? 
									entityObj.getAnimalType()
									: requestObj.getAnimalType());

					// STATUS
					entityObj.setStatus(requestObj.getStatus() == entityObj.getStatus() ? 
							entityObj.getStatus()
							: requestObj.getStatus());

					record.getPetsList().remove(j);
				} else if (null == record.getPetsList().get(j).getId()) { 
					// Novo Pet Cadastrado
					var petObj = new PetsListEntity().builder()
							.petName(record.getPetsList().get(j).getPetName())
							.rating(record.getPetsList().get(j).getRating())
							.animalType(record.getPetsList().get(j).getAnimalType())
							.status(record.getPetsList().get(j).getStatus()).build();

					entity.getPetsList().add(petObj);
					record.getPetsList().remove(j);
				}
			}
		}
		
		this.validateRecordList(record.getPetsList(), entity);
	}

	

	private void updateUsersInfo(Tutor record, TutorEntity entity) {

		// USERNAME
		entity.setUsername(record.getUsername().equalsIgnoreCase(entity.getUsername()) ? entity.getUsername()
				: record.getUsername());

		// ADRESS
		entity.setAddress(record.getAddress().equalsIgnoreCase(entity.getAddress()) ? entity.getAddress()
				: record.getAddress());

	}
	
	private void validateRecordList(List<PetsList> petsList, TutorEntity entity) {
		if (!petsList.isEmpty()) {
			for (br.com.fit.petsInfo.domain.model.PetsList petObj : petsList) {
				var petObjEntity = new PetsListEntity().builder().petName(petObj.getPetName()).rating(petObj.getRating())
						.animalType(petObj.getAnimalType()).status(petObj.getStatus()).build();
				
				entity.getPetsList().add(petObjEntity);
			}
		}
		
	}

	private boolean isUpdateObj(PetsListEntity petsListEntity, PetsList petsList) {
		return (null != petsList.getId()) && (petsListEntity.getId() == petsList.getId());
	}
}
