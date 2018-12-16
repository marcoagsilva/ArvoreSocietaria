package br.com.fatec.companyinvestments.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.companyinvestments.model.Empresas;
import br.com.fatec.companyinvestments.model.Investimentos;
import br.com.fatec.companyinvestments.model.dto.EmpresaInvestidaDTO;
import br.com.fatec.companyinvestments.model.dto.InvestimentosFullDTO;
import br.com.fatec.companyinvestments.repository.EmpresaRepository;
import br.com.fatec.companyinvestments.repository.InvestimentoRepository;

@Service
public class InvestimentoService {
	
	@Autowired
	InvestimentoRepository investimentoRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	public InvestimentosFullDTO Convert(Investimentos investimento) throws Exception {
		try {
			Optional<Empresas> investidora = empresaRepository.findById(investimento.getIdInvestidora());
			Optional<Empresas> investida = empresaRepository.findById(investimento.getIdInvestida());
			
			EmpresaInvestidaDTO investidaDTO = new EmpresaInvestidaDTO();
			investidaDTO.setCompany_cnpj(investida.get().getCompany_cnpj());
			investidaDTO.setCompany_fantasy(investida.get().getCompany_fantasy());
			investidaDTO.setCompany_inscricao(investida.get().getCompany_inscricao());
			investidaDTO.setCompany_name(investida.get().getCompany_name());
			investidaDTO.setCompany_telefone(investida.get().getCompany_telefone());
			investidaDTO.setId(investida.get().getId());
			investidaDTO.setValor_investido(investimento.getValorInvestido());

			InvestimentosFullDTO investimentosFullDTO = new InvestimentosFullDTO();
			investimentosFullDTO.setIdInvestidora(investidora.get().getId());
			investimentosFullDTO.setNomeInvestidora(investidora.get().getCompany_fantasy());
			investimentosFullDTO.setEmpresaInvestida(investidaDTO);
			
			return investimentosFullDTO;
		}
		catch(Exception e) {
			throw e;			
		}
	}

}
