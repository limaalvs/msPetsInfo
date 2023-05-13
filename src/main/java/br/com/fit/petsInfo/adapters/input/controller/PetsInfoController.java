package br.com.fit.petsInfo.adapters.input.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fit.petsInfo.adapters.input.controller.mapper.impl.PetInfoControllerMapper;
import br.com.fit.petsInfo.application.ports.input.PetInfoCreateUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoDeletionUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoRetrieverUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoUpdateUseCase;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.TutorRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.TutorResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/petsInfo")
@Validated
public class PetsInfoController {

	@Autowired
	PetInfoCreateUseCase petInfoCreateUseCase; 
	
	@Autowired 
	PetInfoRetrieverUseCase petInfoRetrieverUseCase; 
	
	@Autowired
	PetInfoUpdateUseCase petInfoUpdateUseCase; 
	
	@Autowired
	PetInfoDeletionUseCase petInfoDeletionUseCase; 
	
	@Autowired
	PetInfoControllerMapper mapper; 
	
	@PostMapping
	public ResponseEntity<TutorResponse> createTutor(@Valid @RequestBody TutorRequest request) {
		var record = petInfoCreateUseCase.createPetInfo(mapper.toUserInfoRecord(request));		
		return new ResponseEntity<>(mapper.toResponsePetInfo(record), HttpStatus.CREATED);	
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TutorResponse> getTutorById(@PathVariable @Min(value = 1, message = "User id should be greater than 0") Long id) {
		var record = petInfoRetrieverUseCase.findPetInfoById(id);
		return new ResponseEntity<>(mapper.toResponsePetInfo(record), HttpStatus.OK);	
	}
	
	@GetMapping()
	public ResponseEntity<List<TutorResponse>> getAllTutors() {
		var recordList = petInfoRetrieverUseCase.findAllPetInfo();
		return new ResponseEntity<>(mapper.toListResponsePetInfo(recordList), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteTutorById(@PathVariable @Min(value = 1, message = "User id should be greater than 0") Long id) {
		petInfoDeletionUseCase.deletePetInfoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TutorResponse> updateTutorById(@PathVariable @Min(value = 1, message = "User id should be greater than 0") Long id, @RequestBody TutorRequest request) {
		var record = petInfoUpdateUseCase.updatePetInfoById(id, mapper.toUserInfoRecord(request));
		return new ResponseEntity<>(mapper.toResponsePetInfo(record), HttpStatus.OK);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintValidatioException(ConstraintViolationException ex) {
		return new ResponseEntity<>("Error: "+ ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
