package com.projeto.p2.Model;

public class Cliente
{
	private int id;
	private String nome,email,telefone,nascimento;
	
	public Cliente(){}
	
	public Cliente(int id, String nome, String email, String telefone, String nascimento)
	{
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
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
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getTelefone()
	{
		return this.telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public String getNascimento()
	{
		return this.nascimento;
	}
	
	public void setNascimento(String nascimento)
	{
		this.nascimento = nascimento;
	}
}
