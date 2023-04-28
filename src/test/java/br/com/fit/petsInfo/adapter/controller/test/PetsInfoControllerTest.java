package br.com.fit.petsInfo.adapter.controller.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fit.petsInfo.adapter.controller.PetsInfoController;
import br.com.fit.petsInfo.application.dto.UserInfoRequest;
import br.com.fit.petsInfo.application.dto.UserInfoResponse;
import br.com.fit.petsInfo.application.port.in.OperationPetsInfoPortIn;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoRequestFactory;
import br.com.fit.petsInfo.petsInfo.factory.UserInfoResponseFactory;

@WebMvcTest(PetsInfoController.class)
public class PetsInfoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private OperationPetsInfoPortIn infosPortIn;
	 
	private UserInfoRequest request ;  
	
	private UserInfoResponse response;
	
	@BeforeEach
	void setUp() {
		request = UserInfoRequestFactory.buildRequestToCreateUser();
		response = UserInfoResponseFactory.buildResponseToCreateUser();
	}
	
	
	@Test
	public void createNewUser_with_sucess() throws Exception {
		given(infosPortIn.createUser(request)).willReturn(response);
		var content = this.objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/petsInfo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content))
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id", is(1)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.userName", is(request.getUsername())));
	}
	
	@Test
	public void getAllUsers__with_success() throws Exception {		
		mockMvc.perform(get("/petsInfo")).andExpect(status().isOk());
	}
	
	@Test
	public void deleteUsersById__with_success() throws Exception {
		mockMvc.perform(delete("/petsInfo/1")).andExpect(status().isOk());
	}
	
	@Test
	public void getById__with_success() throws Exception {
		
		given(infosPortIn.findUserById(1L)).willReturn(response);
		mockMvc.perform(get("/petsInfo/1"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.id",is(1)));
	}
	
	@Test
	public void updateById__with_success() throws Exception {
		given(infosPortIn.createUser(request)).willReturn(response);
		var content = this.objectMapper.writeValueAsString(request);
		
		mockMvc.perform(put("/petsInfo/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content))
		.andExpect(status().isOk());
	}
	
	@Test
	public void whenUsernameIsInvalid_thenReturnsStatus400() throws Exception {
		request.setUsername(null);
		var content = this.objectMapper.writeValueAsString(request);
		
		mockMvc.perform(post("/petsInfo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(content)).andExpect(status().isBadRequest());
	} 
	
	@Test
	public void whenPathVariableGetIsInvalid_thenReturnsStatus400() throws Exception {
		mockMvc.perform(get("/petsInfo/0"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void whenPathVariablePutIsInvalid_thenReturnsStatus400 () throws Exception {
		mockMvc.perform(put("/petsInfo/0"))
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void whenPathVariableDeleteIsInvalid_thenReturnsStatus400 () throws Exception {
		mockMvc.perform(delete("/petsInfo/0")).andExpect(status().isBadRequest());

	}
}
