package com.ceramicamaster.gerenciador2.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ceramicamaster.gerenciador2.entities.Lenha;



public interface LenhaRepositer extends JpaRepository<Lenha, Long> {

	List<Lenha> findByFornecedorContainingIgnoreCase(String Fornecedor);
	
	List<Lenha> findByDataBetween(LocalDate start, LocalDate end);
}
