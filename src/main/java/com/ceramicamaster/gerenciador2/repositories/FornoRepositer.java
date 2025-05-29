package com.ceramicamaster.gerenciador2.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceramicamaster.gerenciador2.entities.Forno;



public interface FornoRepositer extends JpaRepository<Forno, Long> {

	Optional<Forno> findByNumeroDoForno(Integer numeroDoForno);
	
	List<Forno> findByDataDeEntradaBetween(LocalDate start, LocalDate end);
}
