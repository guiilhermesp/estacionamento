package br.com.projeto.estacionamento.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.estacionamento.Dto.VeiculoDto;
import br.com.projeto.estacionamento.modelo.Veiculo;
import br.com.projeto.estacionamento.repository.VeiculoRepository;

@Service
public class VeiculoService {

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

//	public Veiculo getOne(Long id) {
//		return id;
//	}

}
