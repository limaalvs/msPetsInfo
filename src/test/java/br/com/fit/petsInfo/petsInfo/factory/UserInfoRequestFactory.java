package br.com.fit.petsInfo.petsInfo.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.fit.petsInfo.application.dto.PetsList;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.enums.AnimalType;
import br.com.fit.petsInfo.application.enums.Status;

public class UserInfoRequestFactory {
	
	public static UserInfoRequest buildRequestToCreateUser () {
		 var request = new UserInfoRequest();
		 
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
