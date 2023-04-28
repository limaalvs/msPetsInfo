package br.com.fit.petsInfo.adapter.entity;

import br.com.fit.petsInfo.application.enums.AnimalType;
import br.com.fit.petsInfo.application.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PETS")
public class PetsListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id; 
	
	@Column(name = "PET_NAME")
	private String petName;
	
	@Column(name = "RATING")
	private int rating; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ANIMAL_TYPE")
	private AnimalType animalType; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private Status status; 

}
