package br.com.fit.petsInfo.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;

public interface EntityMapper {
	TutorEntity petInfoRecordToEntity(Tutor record);
	Tutor entityToPetInfoRecord(TutorEntity entity);
	List<Tutor> entityListToRecordList(List<TutorEntity> entity);
}
