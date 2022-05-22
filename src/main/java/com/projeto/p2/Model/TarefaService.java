package com.projeto.p2.Model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService
{
	@Autowired
	TarefaDAO tdao;
	
	public void inserirTarefa(Tarefa p)
	{
		tdao.inserirTarefa(p);
	}
	
	public List<Map<String, Object>> getTarefas()
	{
		return tdao.getTarefas();
	}
	
	public void deleteTarefa(int id)
	{
		tdao.deleteTarefa(id);
	}
	
	public Map<String, Object> countTarefas()
	{
		return tdao.countTarefas();
	}
}
