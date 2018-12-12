package br.com.fatec.companyinvestments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Investimentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long idInvestidora;
	
	private Long idInvestida;
	
	private double valorInvestido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
}
