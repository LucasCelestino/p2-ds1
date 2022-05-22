package com.projeto.p2.Model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService
{
	@Autowired
	ProdutoDAO pdao;
	
	public void inserirProduto(Produto p)
	{
		pdao.inserirProduto(p);
	}
	
	public List<Map<String, Object>> getProdutos()
	{
		return pdao.getProdutos();
	}
	
	public void deleteProduto(int id)
	{
		pdao.deleteProduto(id);
	}
	
	public Map<String, Object> getProduto(int id)
	{
		return pdao.getProduto(id);
	}
	
	public void atualizarProduto(int id, Produto p)
	{
		pdao.atualizarProduto(id, p);
	}
	
	public Map<String, Object> countProdutos()
	{
		return pdao.countProdutos();
	}
}