package br.com.fatec.companyinvestments.model.dto;

import java.io.Serializable;

public class InvestimentosDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idInvestidora;
	
	private Long idInvestida;

	private double valorInvestido;

	public Long getIdInvestidora() {
		return idInvestidora;
	}

	public void setIdInvestidora(Long idInvestidora) {
		this.idInvestidora = idInvestidora;
	}

	public Long getIdInvestida() {
		return idInvestida;
	}

	public void setIdInvestida(Long idInvestida) {
		this.idInvestida = idInvestida;
	}

	public double getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(double valorInvestido) {
		this.valorInvestido = valorInvestido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
