package com.projeto.p2.Controller;

import com.projeto.p2.Model.Produto;
import com.projeto.p2.Model.ProdutoService;

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
public class ProdutosController
{
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/produtos")
	public String produtos(Model model)
	{
		ProdutoService pdao = context.getBean(ProdutoService.class);
		List<Map<String, Object>> produtos = pdao.getProdutos();
		model.addAttribute("produtos", produtos);
		return "produtos";
	}
	
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
		model.addAttribute("sucesso", true);
		return "form-produtos";
	}
	
	@GetMapping("/produtos/editar-produto/{id}")
	public String formAtualizar(@PathVariable("id") int id, Model model)
	{
		ProdutoService pdao = context.getBean(ProdutoService.class);
		Map<String, Object> regis = pdao.getProduto(id);
		Produto prod = new Produto(id,regis.get("nome").toString(),regis.get("descricao").toString(),regis.get("preco").toString(),regis.get("estoque").toString());
		model.addAttribute("produto", prod);
		model.addAttribute("id", id);
		return "form-update-produtos";
	}
	
	@PostMapping("/produtos/editar-produto/{id}")
	public String atualizarProduto(@PathVariable("id") int id, Model model, @ModelAttribute Produto prod)
	{
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.atualizarProduto(id, prod);
		model.addAttribute("sucesso", true);
		return "form-update-produtos";
	}
	
	@PostMapping("/produtos/deletar-produto/{id}")
	public String deletarProduto(@PathVariable("id") int id)
	{
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.deleteProduto(id);
		return "redirect:/produtos";
	}
}
