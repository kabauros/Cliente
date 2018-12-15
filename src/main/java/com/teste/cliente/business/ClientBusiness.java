package com.teste.cliente.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.teste.cliente.repository.ClienteJdbcRepository;
import com.teste.cliente.repository.ClimaJdbcRepository;
import com.teste.cliente.service.LocalizaçãoService;
import com.teste.cliente.vo.Cliente;
import com.teste.cliente.vo.Clima;

@Component
public class ClientBusiness {
	
	@Autowired
	private ClienteJdbcRepository clienteRepository;
	
	@Autowired
	private ClimaJdbcRepository climaRepository;
	
	@Autowired
	private LocalizaçãoService service;
	
	public List<Cliente> listAllClients() {
		return clienteRepository.findAll();
	}
	
	public Cliente getClient(@PathVariable("id") long id) {
		return clienteRepository.findById(id);
	}
	
	public void deleteById(long id) {
		clienteRepository.deleteById(id);
	}

	public void insert(Cliente cliente, HttpServletRequest request) {
		Integer clienteId = clienteRepository.insert(cliente);
		
		String ip = "";
		if (request != null) {
			ip = request.getHeader("X-FORWARDED-FOR");
			if (ip == null || "".equals(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		Clima clima = service.getClimaByIp(ip);
		clima.setClienteId(clienteId.toString());
		clima.setIpRequest(ip);
		
		
		climaRepository.insert(clima);
	}

	public void update(Cliente cliente) {
		clienteRepository.update(cliente);
	}
	


}
