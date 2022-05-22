package com.projeto.p2.Model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO 
{
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize()
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public Map<String, Object> countProdutos()
	{
		String sql = "SELECT COUNT(*) AS c FROM produtos";
		return jdbc.queryForMap(sql);
	}
	
	public void inserirProduto(Produto produto)
	{
		String sql = "INSERT INTO produtos (nome,descricao,preco,estoque)" + " VALUES (?,?,?,?)";
		
		Object[] obj = new Object[4];
		
		obj[0] = produto.getNome();
		obj[1] = produto.getDescricao();
		obj[2] = produto.getPreco();
		obj[3] = produto.getEstoque();
		
		jdbc.update(sql, obj);
	}
	
	public List<Map<String, Object>> getProdutos()
	{
		String sql = "SELECT * FROM produtos";
		List<Map<String, Object>> produtos = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return produtos;
	}
	
	public Map<String, Object> getProduto(int id)
	{
		String sql = "SELECT * FROM produtos WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForMap(sql, obj);
	}
	
	public void atualizarProduto(int id, Produto produto)
	{
		String sql = "UPDATE produtos "
				+ "SET nome = ?, descricao = ?, preco = ?, estoque = ? "
				+ "WHERE id = ?";
		Object[] obj = new Object[5];
		obj[0] = produto.getNome();
		obj[1] = produto.getDescricao();
		obj[2] = produto.getPreco();
		obj[3] = produto.getEstoque();
		obj[4] = id;
		jdbc.update(sql, obj);
	}
	
	public void deleteProduto(int id)
	{
		String sql = "DELETE FROM produtos WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}
}
