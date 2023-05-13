package br.com.fit.petsInfo.infrastructure.adapters.input.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.fit.petsInfo.domain.enums.AnimalType;
import br.com.fit.petsInfo.domain.enums.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class PetsListResponse {
	@JsonProperty("id")
	private Long id; 
	
	@JsonProperty("petName")
	private String petName;
	
	@Min(value = 0, message = "The minimum value is required")
	@Max(value = 5, message = "Exceeded the maximum value ")
	@JsonProperty("rating")
	private int rating; 
	
	@JsonProperty("animalType")
	private AnimalType animalType; 
	
	@JsonProperty("status")
	private Status status; 
}
