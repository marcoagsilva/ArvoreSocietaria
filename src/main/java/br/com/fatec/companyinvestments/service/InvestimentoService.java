package br.com.fatec.companyinvestments.service;

import java.util.ArrayList;
import java.util.List;
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

	public List<InvestimentosFullDTO> Convert(List<Investimentos> investimentos) throws Exception {
		try {
			List<InvestimentosFullDTO> investimentosFull = new ArrayList<InvestimentosFullDTO>();
			
			for(int i = 0; i < investimentos.size(); i++) {
				if(i != 0) {
					
					if(investimentos.get(i).getIdInvestidora() != investimentos.get(i-1).getIdInvestidora()) {						
						InvestimentosFullDTO investimentosFullDTO = new InvestimentosFullDTO();
						Optional<Empresas> investidora = empresaRepository.findById(investimentos.get(i).getIdInvestidora());
						investimentosFullDTO.setIdInvestidora(investidora.get().getId());
						investimentosFullDTO.setNomeInvestidora(investidora.get().getCompany_fantasy());
						investimentosFull.add(investimentosFullDTO);
						
						List<Investimentos> temp = investimentoRepository.findByidInvestidora(investimentos.get(i).getIdInvestidora());
						
						List<EmpresaInvestidaDTO> empresaInvestidaDTOList = new ArrayList<EmpresaInvestidaDTO>();
						
						for(int a = 0; a < temp.size(); a++) {							
							Optional<Empresas> investida = empresaRepository.findById(temp.get(a).getIdInvestida());
							EmpresaInvestidaDTO empresaInvestidaDTO = new EmpresaInvestidaDTO();
							empresaInvestidaDTO.setId(investida.get().getId());
							empresaInvestidaDTO.setCompany_cnpj(investida.get().getCompany_cnpj());
							empresaInvestidaDTO.setCompany_fantasy(investida.get().getCompany_fantasy());
							empresaInvestidaDTO.setCompany_inscricao(investida.get().getCompany_inscricao());
							empresaInvestidaDTO.setCompany_name(investida.get().getCompany_name());
							empresaInvestidaDTO.setCompany_telefone(investida.get().getCompany_telefone());
							empresaInvestidaDTO.setValor_investido(temp.get(a).getValorInvestido());
							empresaInvestidaDTOList.add(empresaInvestidaDTO);
						}
						investimentosFullDTO.setEmpresaInvestida(empresaInvestidaDTOList);
					}
				} else {
					System.out.println("Gravar primeiro cabeçalho");
					InvestimentosFullDTO investimentosFullDTO = new InvestimentosFullDTO();
					Optional<Empresas> investidora = empresaRepository.findById(investimentos.get(i).getIdInvestidora());
					investimentosFullDTO.setIdInvestidora(investidora.get().getId());
					investimentosFullDTO.setNomeInvestidora(investidora.get().getCompany_fantasy());
					investimentosFull.add(investimentosFullDTO);
					
					List<Investimentos> temp = investimentoRepository.findByidInvestidora(investimentos.get(i).getIdInvestidora());
					List<EmpresaInvestidaDTO> empresaInvestidaDTOList = new ArrayList<EmpresaInvestidaDTO>();
					
					for(int a = 0; a < temp.size(); a++) {						
						Optional<Empresas> investida = empresaRepository.findById(temp.get(a).getIdInvestida());
						EmpresaInvestidaDTO empresaInvestidaDTO = new EmpresaInvestidaDTO();
						empresaInvestidaDTO.setId(investida.get().getId());
						empresaInvestidaDTO.setCompany_cnpj(investida.get().getCompany_cnpj());
						empresaInvestidaDTO.setCompany_fantasy(investida.get().getCompany_fantasy());
						empresaInvestidaDTO.setCompany_inscricao(investida.get().getCompany_inscricao());
						empresaInvestidaDTO.setCompany_name(investida.get().getCompany_name());
						empresaInvestidaDTO.setCompany_telefone(investida.get().getCompany_telefone());
						empresaInvestidaDTO.setValor_investido(temp.get(a).getValorInvestido());
						empresaInvestidaDTOList.add(empresaInvestidaDTO);
					}
					investimentosFullDTO.setEmpresaInvestida(empresaInvestidaDTOList);
				}
			}
			
			return investimentosFull;
		}
		catch(Exception e) {
			throw e;			
		}
	}

}
