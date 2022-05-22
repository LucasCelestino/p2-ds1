package com.projeto.p2.Controller;

import com.projeto.p2.Model.Cliente;
import com.projeto.p2.Model.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ClientesController
{
	@Autowired
	private ApplicationContext context;
	
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
		return "form-clientes";
	}
}
