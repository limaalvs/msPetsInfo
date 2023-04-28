package br.com.fit.petsInfo.application.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class UserInfoRequest {
	
	@NotNull(message = "UserName is required")
	@NotEmpty(message = "UserName must have a value")
	@NotBlank(message = "UserName must have a valid value")
	@JsonProperty("userName")
	private String username;
	
	@NotNull(message = "CPF is required")
	@NotEmpty(message = "CPF must have a value")
	@NotBlank(message = "CPF must have a valid value")
	@JsonProperty("cpf")
	private String cpf;

	@NotNull(message = "Address is required")
	@NotEmpty(message = "Address must have a value")
	@NotBlank(message = "Address must have a valid value")
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("registrationDate")
	private String registrationDate;
	
	@JsonProperty("petsList")
	private List<PetsList> petsList;
	
}
