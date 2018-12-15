package com.teste.cliente.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.teste.cliente.vo.Cliente;

@Repository
public class ClienteJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Cliente findById(long id) {
		return jdbcTemplate.queryForObject("select * from cliente where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Cliente>(Cliente.class));
	}
	
	class ClienteRowMapper implements RowMapper<Cliente> {
		@Override
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getLong("id"));
			cliente.setNome(rs.getString("nome"));
			cliente.setIdade(rs.getLong("idade"));
			return cliente;
		}
	}

	public List<Cliente> findAll() {
		return jdbcTemplate.query("select * from cliente", new ClienteRowMapper());
	}
	
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from cliente where id=?", new Object[] { id });
	}

	public int insert(Cliente cliente) {
		return jdbcTemplate.update("insert into cliente (id, nome, idade) " + "values(?,  ?, ?)",
				new Object[] { cliente.getId(), cliente.getNome(), cliente.getIdade() });
	}
	
	public int update(Cliente cliente) {
		return jdbcTemplate.update("update cliente " +" set nome = ?, idade = ? "  + " where id = ?",
				new Object[] { cliente.getNome(), cliente.getIdade(), cliente.getId() });
	}
}
