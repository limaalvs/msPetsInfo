package br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;
import br.com.fit.petsInfo.petsInfo.factory.TutorEntityFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorFactory;

@ExtendWith(SpringExtension.class)
class PetInfoUpdatePersistenceMapperTest {

	@InjectMocks
	PetInfoUpdatePersistenceMapper petInfoUpdatePersistenceMapper;
	
	private Tutor record; 
	private TutorEntity entity; 
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		record = TutorFactory.buildTutorMock();
		entity = TutorEntityFactory.buildEntityMock();
	}
	
	
	@Test
	void shouldTutorToEntityWithSuccess() {
		Assertions.assertDoesNotThrow(() -> {
			petInfoUpdatePersistenceMapper.tutorToEntity(record, entity);
			Assertions.assertNotNull(record);
			Assertions.assertNotNull(entity);
			Assertions.assertEquals(record.getUsername(), entity.getUsername());
		});
	}
	
	
	@Test
	void shouldMapperRequestEntityWithSucess() {
		record.setUsername("BatmanEhBruce");
		record.setAddress("Rua dos bobos, 78");
		record.getPetsList().get(0).setId(1L);
		record.getPetsList().get(0).setPetName("Bob");

		Assertions.assertDoesNotThrow(() -> {
			petInfoUpdatePersistenceMapper.tutorToEntity(record, entity);
			Assertions.assertEquals("Bob", entity.getPetsList().get(0).getPetName());
			Assertions.assertEquals("BatmanEhBruce",entity.getUsername());
			Assertions.assertEquals("Rua dos bobos, 78", entity.getAddress());
		});
	}
	
}
