
package br.com.fit.petsInfo.adapters.input.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fit.petsInfo.adapters.input.controller.mapper.impl.PetInfoControllerMapper;
import br.com.fit.petsInfo.application.ports.input.PetInfoCreateUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoDeletionUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoRetrieverUseCase;
import br.com.fit.petsInfo.application.ports.input.PetInfoUpdateUseCase;
import br.com.fit.petsInfo.domain.model.Tutor;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.request.TutorRequest;
import br.com.fit.petsInfo.infrastructure.adapters.input.controller.response.TutorResponse;
import br.com.fit.petsInfo.petsInfo.factory.TutorFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorRequestFactory;
import br.com.fit.petsInfo.petsInfo.factory.TutorResponseFactory;


@WebMvcTest(PetsInfoController.class)
class PetsInfoControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	PetInfoCreateUseCase petInfoCreateUseCase; 
	
	@MockBean
	PetInfoRetrieverUseCase petInfoRetrieverUseCase; 
	
	@MockBean
	PetInfoUpdateUseCase petInfoUpdateUseCase; 
	
	@MockBean
	PetInfoDeletionUseCase petInfoDeletionUseCase; 
	
	@MockBean
	PetInfoControllerMapper mapper;

	private TutorRequest request;

	private TutorResponse response;
	
	private Tutor record; 
	

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		request = TutorRequestFactory.buildRequestMock();
		response = TutorResponseFactory.buildResponseMock();
		record = TutorFactory.buildTutorMock(); 
		
	}

	@Test
	void createNewTutor_with_sucess() throws Exception {
		given(petInfoCreateUseCase.createPetInfo(record)).willReturn(record);
	    given(this.mapper.toUserInfoRecord(request)).willReturn(record);
	    given(this.mapper.toResponsePetInfo(record)).willReturn(response);
	    
		var content = this.objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/petsInfo").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.userName", is(request.getUsername())));
	}

	@Test
	void getAll__with_success() throws Exception {
		var recordList = new ArrayList<Tutor>();
		var TutoResponseList = new ArrayList<TutorResponse>(); 
		recordList.add(record);
		TutoResponseList.add(response);
		given(this.mapper.toListResponsePetInfo(recordList)).willReturn(TutoResponseList);
		mockMvc.perform(get("/petsInfo")).andExpect(status().isOk());
	}

	@Test
	void deleteById__with_success() throws Exception {
		mockMvc.perform(delete("/petsInfo/1")).andExpect(status().isOk());
	}

	@Test
	void getById__with_success() throws Exception {
		given(this.mapper.toResponsePetInfo(record)).willReturn(response);
		given(petInfoRetrieverUseCase.findPetInfoById(1L)).willReturn(record);
		mockMvc.perform(get("/petsInfo/1")).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)));
	}

	@Test
	void updateById__with_success() throws Exception {
		given(petInfoUpdateUseCase.updatePetInfoById(1L, record)).willReturn(record);
		given(this.mapper.toResponsePetInfo(record)).willReturn(response);
	    
		var content = this.objectMapper.writeValueAsString(request);

		mockMvc.perform(put("/petsInfo/1").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isOk());
	}

	@Test
	void whenUsernameIsInvalid_thenReturnsStatus400() throws Exception {
		request.setUsername(null);
		var content = this.objectMapper.writeValueAsString(request);
		mockMvc.perform(post("/petsInfo").contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isBadRequest());
	}

	@Test
	void whenPathVariableGetIsInvalid_thenReturnsStatus400() throws Exception {
		mockMvc.perform(get("/petsInfo/0")).andExpect(status().isBadRequest());
	}

	@Test
	void whenPathVariablePutIsInvalid_thenReturnsStatus400() throws Exception {
		mockMvc.perform(put("/petsInfo/0")).andExpect(status().isBadRequest());
	}

	@Test
	public void whenPathVariableDeleteIsInvalid_thenReturnsStatus400() throws Exception {
		mockMvc.perform(delete("/petsInfo/0")).andExpect(status().isBadRequest());

	}
}
