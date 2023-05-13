package br.com.fit.petsInfo.adapters.input.controller.mapper;

import java.util.List;

import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.TutorRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.TutorResponse;

public interface MapperController {
	Tutor toUserInfoRecord (TutorRequest request);
	TutorResponse toResponsePetInfo (Tutor record);
	List<TutorResponse> toListResponsePetInfo(List<Tutor> record);
}
