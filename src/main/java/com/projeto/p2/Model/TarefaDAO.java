package com.projeto.p2.Model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TarefaDAO 
{
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize()
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public Map<String, Object> countTarefas()
	{
		String sql = "SELECT COUNT(*) AS c FROM tarefas";
		return jdbc.queryForMap(sql);
	}
	
	public void inserirTarefa(Tarefa tarefa)
	{
		String sql = "INSERT INTO tarefas (nome,responsavel, inicio, termino)" + " VALUES (?,?,?,?)";
		
		Object[] obj = new Object[4];
		
		obj[0] = tarefa.getNome();
		obj[1] = tarefa.getResponsavel();
		obj[2] = tarefa.getInicio();
		obj[3] = tarefa.getTermino();
		
		jdbc.update(sql, obj);
	}
	
	public List<Map<String, Object>> getTarefas()
	{
		String sql = "SELECT * FROM tarefas";
		List<Map<String, Object>> tarefas = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return tarefas;
	}
	
	public void deleteTarefa(int id)
	{
		String sql = "DELETE FROM tarefas WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}
}
