package br.com.fit.petsInfo.adapter.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fit.petsInfo.adapter.entity.PetsListEntity;
import br.com.fit.petsInfo.adapter.entity.UserInfoEntity;
import br.com.fit.petsInfo.application.dto.PetsList;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;

@Component
public class UserInfoUpdateObjMapper {

	public void userInfoRequestToEntity(UserInfoRequest request, UserInfoEntity entity) {

		this.updateUsersInfo(request, entity);
		
		for (int i = 0; i < entity.getPetsList().size(); i++) {
			for (int j = 0; j < request.getPetsList().size() && !request.getPetsList().isEmpty(); j++) {
				if (this.isUpdateObj(entity.getPetsList().get(i), request.getPetsList().get(j))) { 
					// Atualiza PetsExistentes

					var entityObj = entity.getPetsList().get(i);
					var requestObj = request.getPetsList().get(j);

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

					request.getPetsList().remove(j);
				} else if (null == request.getPetsList().get(j).getId()) { 
					// Novo Pet Cadastrado
					var petObj = new PetsListEntity().builder()
							.petName(request.getPetsList().get(j).getPetName())
							.rating(request.getPetsList().get(j).getRating())
							.animalType(request.getPetsList().get(j).getAnimalType())
							.status(request.getPetsList().get(j).getStatus()).build();

					entity.getPetsList().add(petObj);
					request.getPetsList().remove(j);
				}
			}
		}
		
		this.validateRequetsList(request.getPetsList(), entity);
	}

	

	private void updateUsersInfo(UserInfoRequest request, UserInfoEntity entity) {

		// USERNAME
		entity.setUsername(request.getUsername().equalsIgnoreCase(entity.getUsername()) ? entity.getUsername()
				: request.getUsername());

		// ADRESS
		entity.setAddress(request.getAddress().equalsIgnoreCase(entity.getAddress()) ? entity.getAddress()
				: request.getAddress());

	}
	
	private void validateRequetsList(List<PetsList> petsList, UserInfoEntity entity) {
		if (!petsList.isEmpty()) {
			for (PetsList petObj : petsList) {
				var petObjEntity = new PetsListEntity().builder().petName(petObj.getPetName()).rating(petObj.getRating())
						.animalType(petObj.getAnimalType()).status(petObj.getStatus()).build();
				
				entity.getPetsList().add(petObjEntity);
			}
		}
		
	}

	private boolean isUpdateObj(PetsListEntity petsListEntity, PetsList petsListRequest) {
		return (null != petsListRequest.getId()) && (petsListEntity.getId() == petsListRequest.getId());
	}
	

}
