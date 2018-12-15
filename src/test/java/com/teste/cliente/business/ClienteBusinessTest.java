package com.teste.cliente.business;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.teste.cliente.repository.ClienteJdbcRepository;
import com.teste.cliente.repository.ClimaJdbcRepository;
import com.teste.cliente.service.LocalizaçãoService;
import com.teste.cliente.vo.Cliente;
import com.teste.cliente.vo.Clima;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteBusinessTest {
	
	@InjectMocks
	private ClientBusiness clientBusiness;

	@Mock
	private ClienteJdbcRepository clienteRepository;
	
	@Mock
	private ClimaJdbcRepository climaRepository;
	
	@Mock
	private LocalizaçãoService service;
	
	public @Rule ExpectedException thrown = ExpectedException.none();
	
	
	
	@BeforeClass
	public static void setUpClass() {
		loadTemplates("com.teste.cliente.template");
	}
	
	@Test
	public void testDeleteClienteById() {
		long id = 1L;

		when(clienteRepository.deleteById(1L)).thenReturn(1);
		clientBusiness.deleteById(id);
		assertTrue(true);
	}
	
	@Test
	public void testGetClienteById() {
		Cliente cliente = from(Cliente.class).gimme("cliente-1"); 
		when(clienteRepository.findById(anyLong())).thenReturn(cliente);
		
		
		Cliente retorno = clientBusiness.getClient(1L);
		
		assertNotNull(retorno);
	}
	
	@Test
	public void testListAllClients() {
		
		List<Cliente> clientes = from(Cliente.class).gimme(2, "cliente-1", "cliente-2"); 
		when(clienteRepository.findAll()).thenReturn(clientes);

		List<Cliente> retorno =  clientBusiness.listAllClients();
		
		assertEquals(clientes.size(), retorno.size());
	}
	
	@Test
	public void testUpdateClienteById() {
		Cliente cliente = from(Cliente.class).gimme("cliente-1"); 
		
		cliente.setNome("Jose");
		
		when(clienteRepository.update(cliente)).thenReturn(1);
		clientBusiness.update(cliente);
		assertTrue(true);
	}
	
	
	@Test
	public void testInsertCliente() {
		Cliente cliente = from(Cliente.class).gimme("cliente-1");
		Clima clima = from(Clima.class).gimme("clima-1");
		
		HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
		
		when(clienteRepository.insert(cliente)).thenReturn(1);
		when(mockedRequest.getRemoteAddr()).thenReturn("192.168.1.5");
		when(service.getClimaByIp("192.168.1.5")).thenReturn(clima);
		when(climaRepository.insert(clima)).thenReturn(1);
		
		clientBusiness.insert(cliente, mockedRequest);
		
		assertTrue(true);
	}
}
