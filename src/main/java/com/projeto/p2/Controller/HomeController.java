package com.projeto.p2.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.projeto.p2.Model.ClienteService;
import com.projeto.p2.Model.ProdutoService;
import com.projeto.p2.Model.RelatorioService;
import com.projeto.p2.Model.TarefaService;


@Controller
public class HomeController
{
    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index(Model model)
    {
      ProdutoService pdao = context.getBean(ProdutoService.class);
      ClienteService cdao = context.getBean(ClienteService.class);
      RelatorioService rdao = context.getBean(RelatorioService.class);
      TarefaService tdao = context.getBean(TarefaService.class);
      Map<String, Object> produtos = pdao.countProdutos();
      Map<String, Object> clientes = cdao.countClientes();
      Map<String, Object> relatorios = rdao.countRelatorios();
      List<Map<String, Object>> tarefas = tdao.getTarefas();
      model.addAttribute("produtos", produtos);
      model.addAttribute("clientes", clientes);
      model.addAttribute("relatorios", relatorios);
      model.addAttribute("tarefas", tarefas);
		  return "index";
    }
}
