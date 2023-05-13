package br.com.fit.petsInfo.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.fit.petsInfo.application.ports.output.PetInfoOutputPort;
import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl.PetInfoPersistenceMapper;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper.impl.PetInfoUpdatePersistenceMapper;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.repository.PetInfoRepository;

@Component
public class PetInfoPersistenceAdapter  implements PetInfoOutputPort {

	@Autowired
	PetInfoPersistenceMapper petInfoMappper; 
	
	@Autowired
	PetInfoUpdatePersistenceMapper updateMapper;
	
	@Autowired
	PetInfoRepository repository; 
	
	
	@Override
	public Tutor savePetInfo(Tutor record) {
		var entity = petInfoMappper.petInfoRecordToEntity(record); 
		return petInfoMappper.entityToPetInfoRecord(repository.save(entity));
	}

	@Override
	public Tutor getPetInfoById(Long id) {
		var entity = repository.findById(id).orElseThrow( 
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found in database"));
		return petInfoMappper.entityToPetInfoRecord(entity);		
	}

	@Override
	public List<Tutor> getAllPetInfos() {
		var entityList = repository.findAll(); 
		
		if (entityList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Any Users found in database");
		}

		return petInfoMappper.entityListToRecordList(entityList);
	}

	
	@Override
	public void deletePetInfoById(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	public Tutor updatePetInfoById(Long id, Tutor record) {
		TutorEntity entity = repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found in database"));

		if (Objects.nonNull(entity)) {
			updateMapper.tutorToEntity(record, entity);
		} 
		
		return petInfoMappper.entityToPetInfoRecord(repository.save(entity));		
	}
}
