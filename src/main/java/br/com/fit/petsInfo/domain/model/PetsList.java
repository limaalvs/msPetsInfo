package br.com.fit.petsInfo.domain.model;

import br.com.fit.petsInfo.domain.enums.AnimalType;
import br.com.fit.petsInfo.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetsList {
	private Long id; 
	private String petName;
	private int rating; 
	private AnimalType animalType; 
	private Status status; 
}
