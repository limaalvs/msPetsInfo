package br.com.fit.petsInfo.petsInfo.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.fit.petsInfo.application.dto.PetsList;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.application.enums.AnimalType;
import br.com.fit.petsInfo.application.enums.Status;

public class UserInfoResponseFactory {
	
	
	public static UserInfoResponse buildResponseToCreateUser() {
		var response = new UserInfoResponse();
		 response.setId(1L);
		 response.setUsername("BruceNaoEhoBatman");
		 response.setCpf("075.969.280-72");
		 response.setAddress("Beco R Dois, 779");
		 response.setPetsList(buildPetListToRequest());
		 
		 return response; 
	}

	
	private static List<PetsList> buildPetListToRequest() {
		List<PetsList> petsList  = new ArrayList<PetsList>();
		
		var petObj = new PetsList();
		petObj.setId(1L);
		petObj.setPetName("Mike");
		petObj.setRating(5);
		petObj.setAnimalType(AnimalType.CACHORRO);
		petObj.setStatus(Status.ADOTADO);
		
		petsList.add(petObj);
		return petsList;
	}
}
