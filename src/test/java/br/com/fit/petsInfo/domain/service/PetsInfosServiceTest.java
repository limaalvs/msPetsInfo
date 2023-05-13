package br.com.fit.petsInfo.domain.service;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.application.ports.output.PetInfoOutputPort;


@ExtendWith(SpringExtension.class)
class PetsInfosServiceTest {

	@InjectMocks
	PetsInfoService petsInfoService;
	
	@Mock
	PetInfoOutputPort petInfoOutputPort;
	

	@Test
	void whenCreatePetInfoIsCallVerify() {
		petsInfoService.createPetInfo(any());
		Mockito.verify(petInfoOutputPort, Mockito.times(1)).savePetInfo(any());
	}

	@Test
	void whenFindPetInfoByIdIsCallVerify() {
		petsInfoService.findPetInfoById(any());
		Mockito.verify(petInfoOutputPort, Mockito.times(1)).getPetInfoById(any());
	}

	@Test
	void whenFindAllPetInfosIsCallVerify() {
		petsInfoService.findAllPetInfo();
		Mockito.verify(petInfoOutputPort, Mockito.times(1)).getAllPetInfos();
	}

	@Test
	void whenDeleteUserByIdIsCallVerify() {
		petsInfoService.deletePetInfoById(any());
		Mockito.verify(petInfoOutputPort, Mockito.times(1)).deletePetInfoById(any());
	}

	@Test
	void whenUpdateByIdIsCallVerify() {
		petsInfoService.updatePetInfoById(any(), any());
		Mockito.verify(petInfoOutputPort, Mockito.times(1)).updatePetInfoById(any(), any());
	}
}
