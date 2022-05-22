package com.projeto.p2.Model;

public class Tarefa
{
	private int id;
	private String nome,responsavel, inicio, termino;
	
	public Tarefa(){}
	
	public Tarefa(int id, String nome, String responsavel, String inicio, String termino)
	{
		this.id = id;
		this.nome = nome;
		this.responsavel = responsavel;
		this.inicio = inicio;
		this.termino = termino;
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
	
	public String getResponsavel()
	{
		return this.responsavel;
	}
	
	public void setResponsavel(String responsavel)
	{
		this.responsavel = responsavel;
	}
	
	public String getInicio()
	{
		return this.inicio;
	}
	
	public void setInicio(String inicio)
	{
		this.inicio = inicio;
	}
	
	public String getTermino()
	{
		return this.termino;
	}
	
	public void setTermino(String termino)
	{
		this.termino = termino;
	}
}
