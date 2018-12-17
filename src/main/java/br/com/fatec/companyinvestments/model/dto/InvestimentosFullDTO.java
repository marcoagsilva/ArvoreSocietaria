package br.com.fatec.companyinvestments.model.dto;

import java.io.Serializable;
import java.util.List;

public class InvestimentosFullDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idInvestidora;
	private String nomeInvestidora;
	private List<EmpresaInvestidaDTO> empresaInvestida;
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
	public List<EmpresaInvestidaDTO> getEmpresaInvestida() {
		return empresaInvestida;
	}
	public void setEmpresaInvestida(List<EmpresaInvestidaDTO> empresaInvestida) {
		this.empresaInvestida = empresaInvestida;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
