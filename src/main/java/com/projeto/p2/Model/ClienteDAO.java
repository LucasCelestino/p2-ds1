package com.projeto.p2.Model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO 
{
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize()
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public Map<String, Object> countClientes()
	{
		String sql = "SELECT COUNT(*) AS c FROM clientes";
		return jdbc.queryForMap(sql);
	}
	
	public void inserirCliente(Cliente cliente)
	{
		String sql = "INSERT INTO clientes (nome,email,telefone,nascimento)" + " VALUES (?,?,?,?)";
		
		Object[] obj = new Object[4];
		
		obj[0] = cliente.getNome();
		obj[1] = cliente.getEmail();
		obj[2] = cliente.getTelefone();
		obj[3] = cliente.getNascimento();
		
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getCliente(int id)
	{
		String sql = "SELECT * FROM clientes WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql, obj);
	}
	
	public List<Map<String, Object>> getClientes()
	{
		String sql = "SELECT * FROM clientes";
		List<Map<String, Object>> clientes = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return clientes;
	}
	
	public void atualizarCliente(int id, Cliente cliente)
	{
		String sql = "UPDATE clientes "
				+ "SET nome = ?, email = ?, telefone = ?, nascimento = ? "
				+ "WHERE id = ?";
		Object[] obj = new Object[5];
		obj[0] = cliente.getNome();
		obj[1] = cliente.getEmail();
		obj[2] = cliente.getTelefone();
		obj[3] = cliente.getNascimento();
		obj[4] = id;
		jdbc.update(sql, obj);
	}
	
	public void deleteCliente(int id)
	{
		String sql = "DELETE FROM clientes WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}
}
