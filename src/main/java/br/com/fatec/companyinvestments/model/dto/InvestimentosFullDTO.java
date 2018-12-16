package br.com.fatec.companyinvestments.model.dto;

import java.io.Serializable;

public class InvestimentosFullDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idInvestidora;
	private String nomeInvestidora;
	private EmpresaInvestidaDTO empresaInvestida;
	
	public Long getIdInvestidora() {
		return idInvestidora;
	}
	public void setIdInvestidora(Long idInvestidora) {
		this.idInvestidora = idInvestidora;
	}
	public String getNomeInvestidora() {
		return nomeInvestidora;
	}
	public void setNomeInvestidora(String nomeInvestidora) {
		this.nomeInvestidora = nomeInvestidora;
	}
	public EmpresaInvestidaDTO getEmpresaInvestida() {
		return empresaInvestida;
	}
	public void setEmpresaInvestida(EmpresaInvestidaDTO empresaInvestida) {
		this.empresaInvestida = empresaInvestida;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
