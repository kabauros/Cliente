package com.teste.cliente.controller;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teste.cliente.business.ClientBusiness;
import com.teste.cliente.controllers.ClienteController;
import com.teste.cliente.vo.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteControllerTest {

	
	@InjectMocks
	private ClienteController clienteController;

	@Mock
	private ClientBusiness business;
	
	private MockMvc mockMvc;
	
	private Gson gson;
	
	public @Rule ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void setUpClass() {
		loadTemplates("com.teste.cliente.template");
	}
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(clienteController)
				.build();
		gson = new GsonBuilder()
                .disableHtmlEscaping()
                .create();
	}
	
	@Test
	public void testGetClientWithSuccess() throws Exception {
		
		Cliente cliente = from(Cliente.class).gimme("cliente-1"); 
		when(business.getClient(1)).thenReturn(cliente);

		//WHEN
		MvcResult andReturn = mockMvc.perform(get("/cliente/1").content(""))

		//THEN
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();
		
		Cliente retorno = gson.fromJson(andReturn.getResponse().getContentAsString(), Cliente.class);
		
		assertEquals(retorno.getId(), cliente.getId());
		assertEquals(retorno.getNome(), cliente.getNome());
		assertEquals(retorno.getIdade(), cliente.getIdade());
	
	}
	

	@Test
	public void testListClienteWithSuccess() throws Exception {
		
		List<Cliente> clientes = from(Cliente.class).gimme(2, "cliente-1", "cliente-2"); 
		when(business.listAllClients()).thenReturn(clientes);

		//WHEN
		MvcResult andReturn = mockMvc.perform(get("/cliente/all").content(""))

		//THEN
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();
		
		@SuppressWarnings("unchecked")
		List<Cliente> retorno =  gson.fromJson(andReturn.getResponse().getContentAsString(), ArrayList.class);
		
		assertEquals(clientes.size(), retorno.size());
		
	}
	
	@Test
	public void testDeleteClienteWithSuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/cliente/123"))
		.andExpect(status().isNoContent());
	}
	
	
	@Test
	public void testInsertClientSuccess() throws Exception {
		Cliente cliente = from(Cliente.class).gimme("cliente-1"); 
		
		String json = gson.toJson(cliente, Cliente.class);
		
		System.out.println(json);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/cliente")
				.content(json)
				.header("Content-Type", "application/json"))
		.andExpect(status().isCreated());
	}
	
	
	@Test
	public void testUpdateClientSuccess() throws Exception {
		Cliente cliente = from(Cliente.class).gimme("cliente-1"); 
		
		String json = gson.toJson(cliente, Cliente.class);
		
		System.out.println(json);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/cliente")
				.content(json)
				.header("Content-Type", "application/json"))
		.andExpect(status().isNoContent());
	}


}
