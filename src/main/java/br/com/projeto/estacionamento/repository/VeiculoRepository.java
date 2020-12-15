package br.com.projeto.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.estacionamento.modelo.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	List<Veiculo> findByModelo(String modelo);
	
//	List<Veiculo> findByPlaca(String placa);
	
}