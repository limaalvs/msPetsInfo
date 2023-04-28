package br.com.fit.petsInfo.adapter.controller;

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

import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.application.port.in.OperationPetsInfoPortIn;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/petsInfo")
@Validated
public class PetsInfoController {

	@Autowired
	OperationPetsInfoPortIn infosPortIn;
	
	@PostMapping
	public ResponseEntity<UserInfoResponse> createUserInfos(@Valid @RequestBody UserInfoRequest request) {
		var response = infosPortIn.createUser(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);	
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserInfoResponse> getUserInfosById(@PathVariable @Min(value = 1, message = "User id should be greater than 0") Long id) {
		var response = infosPortIn.findUserById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}
	
	@GetMapping()
	public ResponseEntity<List<UserInfoResponse>> getAllUsersInfosById() {
		var response = infosPortIn.findAllUsers();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUserInfoByUserName(@PathVariable @Min(value = 1, message = "User id should be greater than 0") Long id) {
		infosPortIn.deleteUserInfo(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserInfoResponse> updateUserInfoByUserName(@PathVariable @Min(value = 1, message = "User id should be greater than 0") Long id, @RequestBody UserInfoRequest request) {
		var response = infosPortIn.updatePetsListByUserName(id, request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintValidatioException(ConstraintViolationException ex) {
		return new ResponseEntity<>("Error: "+ ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
