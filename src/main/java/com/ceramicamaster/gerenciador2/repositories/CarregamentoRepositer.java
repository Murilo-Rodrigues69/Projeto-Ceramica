package com.ceramicamaster.gerenciador2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ceramicamaster.gerenciador2.entities.Carregamento;



public interface CarregamentoRepositer extends JpaRepository<Carregamento, Long> {

	@Query("SELECT c FROM Carregamento c WHERE LOWER(c.motorista.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
	List<Carregamento> findByMotoristaNomeContainingIgnoreCase(@Param("nome") String nome);
}
