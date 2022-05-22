package com.projeto.p2.Controller;

import com.projeto.p2.Model.Relatorio;
import com.projeto.p2.Model.RelatorioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RelatoriosController
{
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/relatorios/adicionar-relatorio")
	public String formRelatorios(Model model)
	{
		model.addAttribute("relatorio", new Relatorio());
		return "form-relatorios";
	}
	
	@PostMapping("/relatorios/adicionar-relatorio")
	public String adicionarRelatorio(@ModelAttribute Relatorio relatorio, Model model)
	{
		RelatorioService rdao = context.getBean(RelatorioService.class);
		rdao.inserirRelatorio(relatorio);
		model.addAttribute("sucesso", true);
		return "form-relatorios";
	}
}
