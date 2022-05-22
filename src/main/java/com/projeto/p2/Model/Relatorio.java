package com.projeto.p2.Model;

public class Relatorio
{
	private int id;
	private String assunto, responsavel, descricao, dtrelatorio;
	
	public Relatorio(){}
	
	public Relatorio(int id, String assunto, String responsavel, String descricao, String dtrelatorio)
	{
		this.id = id;
		this.assunto = assunto;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.dtrelatorio = dtrelatorio;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getAssunto()
	{
		return this.assunto;
	}
	
	public void setAssunto(String assunto)
	{
		this.assunto = assunto;
	}
	
	public String getResponsavel()
	{
		return this.responsavel;
	}
	
	public void setResponsavel(String responsavel)
	{
		this.responsavel = responsavel;
	}
	
	public String getDescricao()
	{
		return this.descricao;
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
	public String getDtrelatorio()
	{
		return this.dtrelatorio;
	}
	
	public void setDtrelatorio(String dtrelatorio)
	{
		this.dtrelatorio = dtrelatorio;
	}
}
