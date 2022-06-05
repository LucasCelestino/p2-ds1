package com.projeto.p2.Controller;

import com.projeto.p2.Model.Relatorio;
import com.projeto.p2.Model.RelatorioService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RelatoriosController
{
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/relatorios")
	public String relatorios(Model model)
	{
		RelatorioService rdao = context.getBean(RelatorioService.class);
		List<Map<String, Object>> relatorios = rdao.getRelatorios();
		model.addAttribute("relatorios", relatorios);
		return "relatorios";
	}
	
	@GetMapping("/relatorios/ver-relatorio/{id}")
	public String verRelatorio(@PathVariable("id") int id, Model model)
	{
		RelatorioService rdao = context.getBean(RelatorioService.class);
		Map<String, Object> relatorio = rdao.getRelatorio(id);
		model.addAttribute("relatorio", relatorio);
		return "ver-relatorio";
	}
	
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
	
	@GetMapping("/relatorios/editar-relatorio/{id}")
	public String formAtualizar(@PathVariable("id") int id, Model model)
	{
		RelatorioService rdao = context.getBean(RelatorioService.class);
		Map<String, Object> regis = rdao.getRelatorio(id);
		Relatorio rel = new Relatorio(id,regis.get("assunto").toString(),regis.get("responsavel").toString(),regis.get("descricao").toString(),regis.get("dtrelatorio").toString());
		model.addAttribute("relatorio", rel);
		model.addAttribute("id", id);
		return "form-update-relatorios";
	}
	
	@PostMapping("/relatorios/editar-relatorio/{id}")
	public String atualizarCliente(@PathVariable("id") int id, Model model, @ModelAttribute Relatorio rel)
	{
		RelatorioService rdao = context.getBean(RelatorioService.class);
		rdao.atualizarRelatorio(id, rel);
		model.addAttribute("sucesso", true);
		return "form-update-relatorios";
	}
}
