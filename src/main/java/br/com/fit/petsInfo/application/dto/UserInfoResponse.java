package br.com.fit.petsInfo.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.fit.petsInfo.adapter.entity.PetsListEntity;
import br.com.fit.petsInfo.application.enums.AnimalType;
import br.com.fit.petsInfo.application.enums.Status;
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
@JsonInclude(value = Include.NON_NULL)
public class UserInfoResponse {
	@JsonProperty("id")
	private Long id; 
	
	@JsonProperty("userName")
	private String username;
	
	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("address")
	private String address;
	
	
	@JsonProperty("registrationDate")
	private String registrationDate;
	
	@JsonProperty("petsList")
	private List<PetsList> petsList;
}
