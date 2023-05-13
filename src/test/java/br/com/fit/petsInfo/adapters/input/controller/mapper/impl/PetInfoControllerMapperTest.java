package br.com.fit.petsInfo.adapters.input.controller.mapper.impl;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.TutorRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.TutorResponse;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;
import br.com.fit.petsInfo.petsInfo.factory.TutorEntityFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorRequestFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorResponseFactory;

@ExtendWith(SpringExtension.class)
public class PetInfoControllerMapperTest {
	@InjectMocks
	PetInfoControllerMapper petInfoControllerMapper;

	private TutorRequest request;

	private TutorResponse response;

	private TutorEntity entity;

	private Tutor record;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = TutorRequestFactory.buildRequestMock();
		response = TutorResponseFactory.buildResponseMock();
		record = TutorFactory.buildTutorMock();
		entity = TutorEntityFactory.buildEntityMock();
	}

	@Test
	void shouldConvertToRecordWithSuccess() {
		Assertions.assertDoesNotThrow(() -> {
			var recordConverted = petInfoControllerMapper.toUserInfoRecord(request);
			Assertions.assertNotNull(recordConverted);
			Assertions.assertEquals(recordConverted.getUsername(), request.getUsername());
		});
	}

	@Test
	void shouldConvertToResponse() {
		Assertions.assertDoesNotThrow(() -> {
			var response = petInfoControllerMapper.toResponsePetInfo(record);
			Assertions.assertNotNull(response);
			Assertions.assertEquals(response.getUsername(), record.getUsername());
		});

	}

	@Test
	void sholdConvertToListResponsePetInfoWithSuccess() {
		var tutorList = new ArrayList<Tutor>();

		Assertions.assertDoesNotThrow(() -> {
			var listResponse = petInfoControllerMapper.toListResponsePetInfo(tutorList);
			Assertions.assertNotNull(listResponse);
			Assertions.assertEquals(tutorList.size(), listResponse.size());
		});

	}

}
