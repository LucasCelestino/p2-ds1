package com.projeto.p2.Model;

public class Produto
{
	private int id;
	private String nome,descricao,estoque,preco;
	
	public Produto(){}
	
	public Produto(int id, String nome, String descricao, String preco, String estoque)
	{
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.estoque = estoque;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getDescricao()
	{
		return this.descricao;
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
	public String getPreco()
	{
		return this.preco;
	}
	
	public void setPreco(String preco)
	{
		this.preco = preco;
	}
	
	public String getEstoque()
	{
		return this.estoque;
	}
	
	public void setEstoque(String estoque)
	{
		this.estoque = estoque;
	}
}
