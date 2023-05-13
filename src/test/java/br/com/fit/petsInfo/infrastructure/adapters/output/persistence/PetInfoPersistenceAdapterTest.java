package br.com.fit.petsInfo.infrastructure.adapters.output.persistence;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.TutorRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.TutorResponse;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl.PetInfoPersistenceMapper;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl.PetInfoUpdatePersistenceMapper;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.repository.PetInfoRepository;
import br.com.fit.petsInfo.petsInfo.factory.TutorEntityFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorRequestFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorResponseFactory;

@ExtendWith(SpringExtension.class)
class PetInfoPersistenceAdapterTest {
	
	@InjectMocks
	PetInfoPersistenceAdapter petInfoPersistenceAdapter;
	
	@Mock
	PetInfoPersistenceMapper petInfoMappper; 
	
	@Mock
	PetInfoUpdatePersistenceMapper updateMapper;
	
	@Mock
	PetInfoRepository repository;
	
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
	void shouldSavePetWithSucess() {
		doReturn(entity).when(petInfoMappper).petInfoRecordToEntity(record);
		doReturn(entity).when(repository).save(any());
		doReturn(record).when(petInfoMappper).entityToPetInfoRecord(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			var recordResponse = petInfoPersistenceAdapter.savePetInfo(record);
			Assertions.assertNotNull(recordResponse);
		});
	}
	
	@Test
	void shouldFindByIdWithSucess() {
		doReturn(Optional.of(entity)).when(repository).findById(any());
		doReturn(record).when(petInfoMappper).entityToPetInfoRecord(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			petInfoPersistenceAdapter.getPetInfoById(1L);
		});
	}
	
	@Test 
	void shouldFindAllWithSucess() {
		var entityList = new ArrayList<TutorEntity>();
		var recordList = new ArrayList<Tutor>();
		
		entityList.add(entity);
		recordList.add(record);
		
		doReturn(entityList).when(repository).findAll();
		doReturn(recordList).when(petInfoMappper).entityListToRecordList(entityList);
		
		
		Assertions.assertDoesNotThrow(() -> {
			var recorResponse = petInfoPersistenceAdapter.getAllPetInfos();
			Assertions.assertNotNull(recorResponse);
			Assertions.assertEquals(recordList.size(), recorResponse.size());
		});
	}
	
	@Test
	void shouldNotFindByInvalidId() {
		assertThrows(ResponseStatusException.class, () -> {
			petInfoPersistenceAdapter.getPetInfoById(3L);
		});
	}
	
	@Test
	void shouldNotFindAnyInfos() {
		var entityList = new ArrayList<TutorEntity>();
		var recordList = new ArrayList<Tutor>();
		
		assertThrows(ResponseStatusException.class, () -> {
			petInfoPersistenceAdapter.getAllPetInfos();
		});
	}
	
	
	@Test
	void shouldDeleteByIdWithSucess() {
		Assertions.assertDoesNotThrow(() -> {
			petInfoPersistenceAdapter.deletePetInfoById(3L);
		});
	}
	
	
	@Test
	void shoulUpdateEntityWithSucess() {
		doReturn(Optional.of(entity)).when(repository).findById(any());
		doReturn(entity).when(repository).save(any());
		doReturn(record).when(petInfoMappper).entityToPetInfoRecord(entity);
		
		Assertions.assertDoesNotThrow(() -> {
			petInfoPersistenceAdapter.updatePetInfoById(1L, record);
		});
	}
	
	
	@Test
	void shouldNotFindByInvalidIdToUpdate() {
		assertThrows(ResponseStatusException.class, () -> {
			petInfoPersistenceAdapter.updatePetInfoById(1L, record);
		});
	}
	
	@Test
	void shouldNotFindByInvalidIdEntityNull() {
		Optional<TutorEntity> entiyObj = Optional.of(new TutorEntity());

		doReturn(entiyObj).when(repository).findById(any());
		doReturn(entity).when(repository).save(any());
		doReturn(record).when(petInfoMappper).entityToPetInfoRecord(any());
		
		Assertions.assertDoesNotThrow(() -> {
			petInfoPersistenceAdapter.updatePetInfoById(1L, record);
		});
	}
}
