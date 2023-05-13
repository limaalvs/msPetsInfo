package br.com.fit.petsInfo.application.ports.input;

import br.com.fit.petsInfo.domain.model.Tutor;

public interface PetInfoUpdateUseCase {
	Tutor updatePetInfoById(Long id, Tutor record);
}
