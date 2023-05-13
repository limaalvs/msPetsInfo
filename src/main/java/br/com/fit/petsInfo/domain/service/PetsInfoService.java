package br.com.fit.petsInfo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fit.petsInfo.application.ports.input.PetInfoCreateUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoDeletionUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoRetrieverUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoUpdateUseCase;
import br.com.fit.petsInfo.application.ports.output.PetInfoOutputPort;
import br.com.fit.petsInfo.domain.model.Tutor;

@Service
public class PetsInfoService implements PetInfoCreateUseCase,PetInfoRetrieverUseCase, PetInfoUpdateUseCase, PetInfoDeletionUseCase {

	@Autowired
	PetInfoOutputPort petInfoOutputPort;
	
	@Override
	public Tutor createPetInfo(Tutor record) {
		return petInfoOutputPort.savePetInfo(record);
	}

	@Override
	public Tutor findPetInfoById(Long id) {
		return petInfoOutputPort.getPetInfoById(id);
	}
	
	@Override
	public List<Tutor> findAllPetInfo() {
		return petInfoOutputPort.getAllPetInfos();
	}
	
	@Override
	public Tutor updatePetInfoById(Long id, Tutor record) {
		return petInfoOutputPort.updatePetInfoById(id, record);
	}

	@Override
	public void deletePetInfoById(Long id) {
		petInfoOutputPort.deletePetInfoById(id);
	}

}
