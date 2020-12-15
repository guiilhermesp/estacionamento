package br.com.projeto.estacionamento.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarifa {
	
	// Utilizar o exemplo do Andrey como exemplo para a construção
	// Valores fixos para testar funcionalidade do controle de horario para tarifa
	public String dataEntrada = "01/12/20 12:00:00";
	public String dataSaida = "02/12/20 12:00:00";
	
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH:MM:ss");
//	Date d1 = null;
//	Date d2 = null;
	
	try {
		Date d1 = format.parse(dataEntrada);
		Date d2 = format.parse(dataSaida);
		
		long dif = d2.getTime() - d1.getTime();
		
		long difHoras = dif / ( 60 * 60 * 1000 ) % 24;
		
		System.out.println(difHoras + "horas");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}