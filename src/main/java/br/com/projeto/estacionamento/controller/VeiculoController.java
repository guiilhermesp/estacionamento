package br.com.projeto.estacionamento.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projeto.estacionamento.Dto.VeiculoDto;
import br.com.projeto.estacionamento.controller.form.AtualizacaoVeiculoForm;
import br.com.projeto.estacionamento.controller.form.VeiculoForm;
import br.com.projeto.estacionamento.modelo.Veiculo;
import br.com.projeto.estacionamento.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
	
//	@Autowired
//	public VeiculoService veiculoService;
	
	// Lista de veiculos cadastrados no estacionamento!
	@Autowired
	public VeiculoRepository veiculoRepository;

	public List<VeiculoDto> listaVeiculos(String modelo) {
		if (modelo == null) {
			List<Veiculo> veiculos = veiculoRepository.findAll();
			return VeiculoDto.converter(veiculos);
		} else {
			List<Veiculo> veiculos = veiculoRepository.findByModelo(modelo);
			return VeiculoDto.converter(veiculos);
		}
	}

	@Transactional
	public void save(Veiculo veiculo) {
		veiculoRepository.save(veiculo);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriBuilder) {
		Veiculo veiculo = form.converter();
		veiculoRepository.save(veiculo);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(veiculo.getId()).toUri();
		return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<VeiculoDto> detalhar(@PathVariable Long id) {
		
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			return ResponseEntity.ok( new VeiculoDto(veiculo.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeiculoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoVeiculoForm form) {
		
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		
		if (optional.isPresent()) {
			Veiculo veiculo = form.atualizar(id, veiculoRepository);
			return ResponseEntity.ok(new VeiculoDto(veiculo));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		
		Optional<Veiculo> optional = veiculoRepository.findById(id);
		
		if (optional.isPresent()) {
			veiculoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
}