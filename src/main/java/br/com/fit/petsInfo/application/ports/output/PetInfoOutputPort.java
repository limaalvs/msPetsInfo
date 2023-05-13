package br.com.fit.petsInfo.application.ports.output;

import java.util.List;

import br.com.fit.petsInfo.domain.model.Tutor;

public interface PetInfoOutputPort {
	Tutor savePetInfo(Tutor record);
	Tutor getPetInfoById(Long id);
	List<Tutor> getAllPetInfos();
	Tutor updatePetInfoById(Long id, Tutor record);
	void deletePetInfoById(Long id);
}
