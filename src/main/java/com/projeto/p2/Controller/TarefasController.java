package com.projeto.p2.Controller;

import com.projeto.p2.Model.Tarefa;
import com.projeto.p2.Model.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class TarefasController
{
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/adicionar-tarefa")
	public String adicionarTarefa(Model model)
	{
		model.addAttribute("tarefa", new Tarefa());
		return "form-tarefas";
	}
	
	@PostMapping("/adicionar-tarefa")
	public String adicionarTarefa(@ModelAttribute Tarefa tarefa, Model model)
	{
		TarefaService tdao = context.getBean(TarefaService.class);
		tdao.inserirTarefa(tarefa);
		model.addAttribute("sucesso", true);
		return "form-tarefas";
	}
}
