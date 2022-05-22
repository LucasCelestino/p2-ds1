package com.projeto.p2.Model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RelatorioDAO 
{
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize()
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirRelatorio(Relatorio relatorio)
	{
		String sql = "INSERT INTO relatorios (assunto, responsavel, descricao, dtrelatorio)" + " VALUES (?,?,?,?)";
		
		Object[] obj = new Object[4];
		
		obj[0] = relatorio.getAssunto();
		obj[1] = relatorio.getResponsavel();
		obj[2] = relatorio.getDescricao();
		obj[3] = relatorio.getDtrelatorio();
		
		jdbc.update(sql, obj);
	}

	public Map<String, Object> countRelatorios()
	{
		String sql = "SELECT COUNT(*) AS c FROM relatorios";
		return jdbc.queryForMap(sql);
	}
	
	public List<Map<String, Object>> getRelatorios()
	{
		String sql = "SELECT * FROM relatorios";
		List<Map<String, Object>> relatorios = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return relatorios;
	}
	
	public Map<String, Object> getRelatorio(int id)
	{
		String sql = "SELECT * FROM relatorios WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql, obj);
	}
	
	public void atualizarRelatorio(int id, Relatorio relatorio)
	{
		String sql = "UPDATE relatorios "
				+ "SET assunto = ?, responsavel = ?, descricao = ?, dtrelatorio = ? "
				+ "WHERE id = ?";
		Object[] obj = new Object[5];
		obj[0] = relatorio.getAssunto();
		obj[1] = relatorio.getResponsavel();
		obj[2] = relatorio.getDescricao();
		obj[3] = relatorio.getDtrelatorio();
		obj[4] = id;
		jdbc.update(sql, obj);
	}
	
	public void deleteRelatorio(int id)
	{
		String sql = "DELETE FROM relatorios WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}
}
