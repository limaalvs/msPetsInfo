package br.com.fit.petsInfo.petsInfo.factory;

import java.util.ArrayList;
import java.util.Date;

import br.com.fit.petsInfo.domain.enums.AnimalType;
import br.com.fit.petsInfo.domain.enums.Status;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.PetsListEntity;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;

public class TutorEntityFactory {
	
	
	public static TutorEntity buildEntityMock() {
		var entity = new TutorEntity();
		var petListEntity = new PetsListEntity();
		
		entity.setId(1L);
		entity.setAddress("Beco R Dois, 779");
		entity.setUsername("BruceNaoEhoBatman");
		entity.setCpf("075.969.280-72");
		entity.setRegistrationDate(new Date().toString());
		
		petListEntity.setId(1L); 
		petListEntity.setPetName("Mike");
		petListEntity.setRating(5);
		petListEntity.setAnimalType(AnimalType.CACHORRO);
		petListEntity.setStatus(Status.ADOTADO);
	
		entity.setPetsList(new ArrayList<>());
		entity.getPetsList().add(petListEntity);
		
		return entity;
	}

}
