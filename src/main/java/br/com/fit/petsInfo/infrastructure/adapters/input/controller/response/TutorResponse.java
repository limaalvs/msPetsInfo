package br.com.fit.petsInfo.infrastructure.adapters.input.controller.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.PetsListRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class TutorResponse {
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
	private List<PetsListResponse> petsList;
}
