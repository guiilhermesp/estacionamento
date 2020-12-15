package br.com.projeto.estacionamento.Dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.projeto.estacionamento.modelo.Veiculo;

public class VeiculoDto {
	
	private Long id;
	private String marca;
	private String modelo;
	private String placa;
	
	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.placa = veiculo.getPlaca();
	}
	
	public Long getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getPlaca() {
		return placa;
	}

	public static List<VeiculoDto> converter(List<Veiculo> veiculos) {
		return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());
	}
	
}
