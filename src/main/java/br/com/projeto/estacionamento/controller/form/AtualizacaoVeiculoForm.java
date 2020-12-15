package br.com.projeto.estacionamento.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.projeto.estacionamento.modelo.Veiculo;
import br.com.projeto.estacionamento.repository.VeiculoRepository;

public class AtualizacaoVeiculoForm {

	@NotNull @NotEmpty
	private String marca;
	@NotNull @NotEmpty @Length(min = 2)
	private String modelo;
	@NotNull @NotEmpty @Length(min = 7)
	private String placa;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Veiculo atualizar(Long id, VeiculoRepository veiculoRepository) {
		Veiculo veiculo = veiculoRepository.getOne(id);
		veiculo.setMarca(this.marca);
		veiculo.setModelo(this.modelo);
		veiculo.setPlaca(this.placa);
		
		return veiculo;
	}
	
	
	
}
