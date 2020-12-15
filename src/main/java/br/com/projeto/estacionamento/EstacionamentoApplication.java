package br.com.projeto.estacionamento;

//import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.projeto.estacionamento.modelo"})
public class EstacionamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}
}
