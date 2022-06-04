package com.projeto.p2.Controller;

import com.projeto.p2.Model.Cliente;
import com.projeto.p2.Model.ClienteService;

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
public class ClientesController
{
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/clientes")
	public String clientes(Model model)
	{
		ClienteService cdao = context.getBean(ClienteService.class);
		List<Map<String, Object>> clientes = cdao.getClientes();
		model.addAttribute("clientes", clientes);
		return "clientes";
	}
	
	@GetMapping("/clientes/adicionar-cliente")
	public String formClientes(Model model)
	{
		model.addAttribute("cliente", new Cliente());
		return "form-clientes";
	}
	
	@PostMapping("/clientes/adicionar-cliente")
	public String adicionarCliente(@ModelAttribute Cliente cli, Model model)
	{
		ClienteService cdao = context.getBean(ClienteService.class);
		cdao.inserirCliente(cli);
		model.addAttribute("sucesso", "teste");
		return "form-clientes";
	}
	
	@GetMapping("/clientes/editar-cliente/{id}")
	public String formAtualizar(@PathVariable("id") int id, Model model)
	{
		ClienteService cdao = context.getBean(ClienteService.class);
		Map<String, Object> regis = cdao.getCliente(id);
		Cliente cli = new Cliente(id,regis.get("nome").toString(),regis.get("email").toString(),regis.get("telefone").toString(),regis.get("nascimento").toString());
		model.addAttribute("cliente", cli);
		model.addAttribute("id", id);
		return "form-update-clientes";
	}
	
	@PostMapping("/clientes/editar-cliente/{id}")
	public String atualizarCliente(@PathVariable("id") int id, Model model, @ModelAttribute Cliente cli)
	{
		ClienteService cdao = context.getBean(ClienteService.class);
		cdao.atualizarCliente(id, cli);
		model.addAttribute("sucesso", true);
		return "form-update-clientes";
	}
	
	@PostMapping("/clientes/deletar-cliente/{id}")
	public String deletarCliente(@PathVariable("id") int id)
	{
		ClienteService cdao = context.getBean(ClienteService.class);
		cdao.deleteCliente(id);
		return "redirect:/clientes";
	}
}
