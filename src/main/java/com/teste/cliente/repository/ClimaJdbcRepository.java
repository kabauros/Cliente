package com.teste.cliente.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.teste.cliente.vo.Clima;

@Repository
public class ClimaJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insert(Clima clima) {
		return jdbcTemplate.update(
				"insert into clima (id, id_cliente, data_inclusão, temperatura_minima, temperatura_maxima, ip_request) "
						+ "values(?, ?, ?, ?, ?, ?)",
				new Object[] { clima.getId(), clima.getClienteId(), clima.getDataInclusao(),
						clima.getTemperaturaMinima(), clima.getTemperaturaMaxima(), clima.getIpRequest() });
	}

}
