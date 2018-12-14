package br.com.fatec.companyinvestments.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.companyinvestments.model.Empresas;
import br.com.fatec.companyinvestments.model.Investimentos;
import br.com.fatec.companyinvestments.model.InvestimentosDTO;
import br.com.fatec.companyinvestments.repository.EmpresaRepository;
import br.com.fatec.companyinvestments.repository.InvestimentoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmpresaController {
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	InvestimentoRepository investimentoRepository;
	
	@GetMapping
	public List<Empresas> listar() {
		return empresaRepository.findAll();
	}
	
	@GetMapping("{empresaId}")
	public ResponseEntity<Optional<Empresas>> getDoctor(@PathVariable Long empresaId) {
		Optional<Empresas> empresa = empresaRepository.findById(empresaId);

		if (empresa == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empresa);
	}

	@PostMapping
	public Empresas create(@Valid @RequestBody Empresas company) {
		return empresaRepository.save(company);
	}
	
	@PutMapping
	public Empresas alterar(@Valid @RequestBody Empresas company) {
		return empresaRepository.save(company);
	}
	
	@DeleteMapping("{empresaID}")
	public ResponseEntity<Empresas> delete(@PathVariable Long empresaID) {
		empresaRepository.deleteById(empresaID);
		return ResponseEntity.ok(new Empresas());
	}
	
	// Investments
	@GetMapping("/investir")
	public List<Investimentos> listarInvestimentos() {
		return investimentoRepository.findAll();
	}
	
	@GetMapping("/investir/{investimentoID}")
	public ResponseEntity<Optional<Investimentos>> getInvestidora(@PathVariable Long investimentoID) {
		Optional<Investimentos> investimento = investimentoRepository.findById(investimentoID);

		if (investimento == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(investimento);
	}
	
	@GetMapping("/investir/investidora/{idInvestidora}")
	public List<Investimentos> listarInvestimentosInvestidora(@PathVariable Long idInvestidora) {
		
		if(idInvestidora == null || idInvestidora == 0) {
			return investimentoRepository.findAll();
		} else {
			return investimentoRepository.findByidInvestidora(idInvestidora);
		}
	}
	
	@PostMapping("/investir")
	public ResponseEntity<Investimentos> investir(@Valid @RequestBody InvestimentosDTO investimentoDTO) {
		Investimentos investimento = new Investimentos();
		
		investimento.setIdInvestidora(investimentoDTO.getIdInvestidora());
		investimento.setIdInvestida(investimentoDTO.getIdInvestida());
		investimento.setValorInvestido(investimentoDTO.getValorInvestido());
		
		investimentoRepository.save(investimento);
		
		return ResponseEntity.ok(investimento);
	}
	
	@PutMapping("/investir")
	public Investimentos alterarInvestimento(@Valid @RequestBody Investimentos investimento) {
		return investimentoRepository.save(investimento);
	}
	
	@DeleteMapping("/investir/{empresaID}")
	public ResponseEntity<Investimentos> deletarInvestimento(@PathVariable Long investimentoID) {
		empresaRepository.deleteById(investimentoID);
		return ResponseEntity.ok(new Investimentos());
	}
}
