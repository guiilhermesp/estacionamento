package br.com.projeto.estacionamento.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.projeto.estacionamento.modelo.Veiculo;

public class VeiculoForm {

	@NotNull @NotEmpty
	private String marca;
	@NotNull @NotEmpty @Length(min = 2)
	private String modelo;
	@NotNull @NotEmpty @Length(min = 7)
	private String placa;
	
	

	public VeiculoForm() {
	}
	
	public VeiculoForm(String marca, String modelo, String placa) {
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}

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

	public Veiculo converter() {
		return new Veiculo(marca, modelo, placa);
	}
	
}
