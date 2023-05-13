
package br.com.fit.petsInfo.petsInfo.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.fit.petsInfo.domain.enums.AnimalType;
import br.com.fit.petsInfo.domain.enums.Status;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.PetsListResponse;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.TutorResponse;

public class TutorResponseFactory {

	public static TutorResponse buildResponseMock() {
		var response = new TutorResponse();
		response.setId(1L);
		response.setUsername("BruceNaoEhoBatman");
		response.setCpf("075.969.280-72");
		response.setAddress("Beco R Dois, 779");
		response.setPetsList(buildPetListToRequest());

		return response;
	}

	private static List<PetsListResponse> buildPetListToRequest() {
		List<PetsListResponse> petsList = new ArrayList<PetsListResponse>();

		var petObj = new PetsListResponse();
		petObj.setId(1L);
		petObj.setPetName("Mike");
		petObj.setRating(5);
		petObj.setAnimalType(AnimalType.CACHORRO);
		petObj.setStatus(Status.ADOTADO);

		petsList.add(petObj);
		return petsList;
	}
}
