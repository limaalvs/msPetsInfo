package br.com.fit.petsInfo.petsInfo.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.fit.petsInfo.domain.enums.AnimalType;
import br.com.fit.petsInfo.domain.enums.Status;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.TutorRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.PetsListRequest;

public class TutorRequestFactory {
	
	public static TutorRequest buildRequestMock () {
		 var request = new TutorRequest();
		 
		 request.setUsername("BruceNaoEhoBatman");
		 request.setCpf("075.969.280-72");
		 request.setAddress("Beco R Dois, 779");
		 request.setPetsList(buildPetListToRequest());
		 
		 return request;
	}

	private static List<PetsListRequest> buildPetListToRequest() {
		List<PetsListRequest> petsList  = new ArrayList<PetsListRequest>();
		
		var petObj = new PetsListRequest();
		petObj.setPetName("Mike");
		petObj.setRating(5);
		petObj.setAnimalType(AnimalType.CACHORRO);
		petObj.setStatus(Status.ADOTADO);
		
		petsList.add(petObj);
		return petsList;
	}
}
