package com.teste.cliente.controllers;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cliente.business.ClientBusiness;
import com.teste.cliente.vo.Cliente;

@RestController
public class ClienteController {

	@Autowired
	private ClientBusiness business;

	@RequestMapping(value = "/cliente/all", produces = APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<Cliente> listAllClients() {
		return business.listAllClients();
	}

	@RequestMapping(value = "/cliente/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public Cliente getClient(@PathVariable("id") long id) {
		return business.getClient(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/cliente")
	@ResponseStatus(CREATED)
	public void insertSeal(@RequestBody Cliente cliente,  HttpServletRequest request) {
		business.insert(cliente, request);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/cliente")
	@ResponseStatus(NO_CONTENT)
	public void updateSeal(@RequestBody Cliente cliente) {
		business.update(cliente);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/cliente/{id}")
	@ResponseStatus(NO_CONTENT)
	public void deleteSeal(@PathVariable("id") long id) {
		business.deleteById(id);
	}

}
