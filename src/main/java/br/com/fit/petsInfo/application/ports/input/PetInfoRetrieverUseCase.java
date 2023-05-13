package br.com.fit.petsInfo.application.ports.input;

import java.util.List;

import br.com.fit.petsInfo.domain.model.Tutor;

public interface PetInfoRetrieverUseCase {
	Tutor findPetInfoById(Long id);
	List<Tutor> findAllPetInfo();
}
