package br.com.fit.petsInfo.domain.model;

import java.util.List;

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
public class Tutor {
	private Long id; 	
	private String username;
	private String cpf;
	private String address;
	private String registrationDate;
	private List<PetsList> petsList;
}
