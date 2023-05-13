package br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl;

import java.util.ArrayList;

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
class PetInfoPersistenceMapperTest {

	@InjectMocks
	PetInfoPersistenceMapper petInfoPersistenceMapper;
	
	private Tutor record; 
	
	private TutorEntity entity; 
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		record = TutorFactory.buildTutorMock();
		entity = TutorEntityFactory.buildEntityMock();
	}
	
	@Test
	void shouldConvertRecordToEntityWithSucess() {
		Assertions.assertDoesNotThrow(() -> {
			var entity = petInfoPersistenceMapper.petInfoRecordToEntity(record);
			
			Assertions.assertNotNull(entity);
			Assertions.assertEquals(entity.getUsername(), record.getUsername());
		});
	}
	
	@Test
	void shouldConvertEntityToPetInfoRecord() {
		Assertions.assertDoesNotThrow(() -> {
			var convertedRecord = petInfoPersistenceMapper.entityToPetInfoRecord(entity);
			Assertions.assertNotNull(entity);
			Assertions.assertEquals(entity.getUsername(), convertedRecord.getUsername());
		});
	}
	
	@Test
	void shouldConvertEntityListToRecordList() {
		var entityList = new ArrayList<TutorEntity>();
		
		entityList.add(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			var recordList = petInfoPersistenceMapper.entityListToRecordList(entityList);
			Assertions.assertNotNull(entity);
			Assertions.assertEquals(entityList.size(), recordList.size());
		});
	}
}
