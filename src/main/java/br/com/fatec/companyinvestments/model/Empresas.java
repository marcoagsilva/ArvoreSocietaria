package br.com.fatec.companyinvestments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String company_name; // razao social
	
	private String company_fantasy; //nome
	
	private String company_cnpj;
	
	private String company_telefone;
	
	private String company_inscricao; // inscricao estadual

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_fantasy() {
		return company_fantasy;
	}

	public void setCompany_fantasy(String company_fantasy) {
		this.company_fantasy = company_fantasy;
	}

	public String getCompany_cnpj() {
		return company_cnpj;
	}

	public void setCompany_cnpj(String company_cnpj) {
		this.company_cnpj = company_cnpj;
	}

	public String getCompany_telefone() {
		return company_telefone;
	}

	public void setCompany_telefone(String company_telefone) {
		this.company_telefone = company_telefone;
	}

	public String getCompany_inscricao() {
		return company_inscricao;
	}

	public void setCompany_inscricao(String company_inscricao) {
		this.company_inscricao = company_inscricao;
	}
}
