package br.com.fatec.companyinvestments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.companyinvestments.model.Investimentos;

public interface InvestimentoRepository extends JpaRepository<Investimentos, Long> {
	
	public List<Investimentos> findByidInvestidora(Long idInvestidora);	
}
