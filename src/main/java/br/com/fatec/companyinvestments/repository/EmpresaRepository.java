package br.com.fatec.companyinvestments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatec.companyinvestments.model.Empresas;

public interface EmpresaRepository extends JpaRepository<Empresas, Long> {
}
