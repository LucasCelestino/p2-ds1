package com.projeto.p2.Model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService
{
	@Autowired
	RelatorioDAO rdao;
	
	public void inserirRelatorio(Relatorio r)
	{
		rdao.inserirRelatorio(r);
	}
	
	public List<Map<String, Object>> getRelatorios()
	{
		return rdao.getRelatorios();
	}
	
	public Map<String, Object> getRelatorio(int id)
	{
		return rdao.getRelatorio(id);
	}
	
	public Map<String, Object> countRelatorios()
	{
		return rdao.countRelatorios();
	}
	
	public void atualizarRelatorio(int id, Relatorio r)
	{
		rdao.atualizarRelatorio(id, r);
	}
	
	public void deleteRelatorio(int id)
	{
		rdao.deleteRelatorio(id);
	}
}
