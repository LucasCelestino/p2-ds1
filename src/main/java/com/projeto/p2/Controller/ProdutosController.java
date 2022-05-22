package com.projeto.p2.Controller;

import com.projeto.p2.Model.Produto;
import com.projeto.p2.Model.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProdutosController
{
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/produtos/adicionar-produto")
	public String formProdutos(Model model)
	{
		model.addAttribute("produto", new Produto());
		return "form-produtos";
	}
	
	@PostMapping("/produtos/adicionar-produto")
	public String adicionarProduto(@ModelAttribute Produto prod, Model model)
	{
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.inserirProduto(prod);
		return "form-produtos";
	}
}
