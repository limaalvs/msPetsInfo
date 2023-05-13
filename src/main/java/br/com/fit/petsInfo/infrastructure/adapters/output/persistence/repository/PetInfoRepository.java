package br.com.fit.petsInfo.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fit.petsInfo.infrastructure.adapters.output.persistence.entity.TutorEntity;

@Repository
public interface PetInfoRepository extends JpaRepository<TutorEntity, Long> {
}
