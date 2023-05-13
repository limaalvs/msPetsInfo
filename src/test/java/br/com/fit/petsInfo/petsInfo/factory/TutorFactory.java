package br.com.fit.petsInfo.petsInfo.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.fit.petsInfo.domain.enums.AnimalType;
import br.com.fit.petsInfo.domain.enums.Status;
import br.com.fit.petsInfo.domain.model.PetsList;
import br.com.fit.petsInfo.domain.model.Tutor;

public class TutorFactory {
	
	public static Tutor buildTutorMock () {
		 var request = new Tutor();
		 
		 request.setUsername("BruceNaoEhoBatman");
		 request.setCpf("075.969.280-72");
		 request.setAddress("Beco R Dois, 779");
		 request.setPetsList(buildPetListToRequest());
		 
		 return request;
	}

	private static List<PetsList> buildPetListToRequest() {
		List<PetsList> petsList  = new ArrayList<PetsList>();
		
		var petObj = new PetsList();
		petObj.setPetName("Mike");
		petObj.setRating(5);
		petObj.setAnimalType(AnimalType.CACHORRO);
		petObj.setStatus(Status.ADOTADO);
		
		petsList.add(petObj);
		return petsList;
	}
}
