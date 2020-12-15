package br.com.projeto.estacionamento.modelo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Estacionamento {

	private String placa;
	private static String entrada;
	private static String saida;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public static String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public static String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	
}
