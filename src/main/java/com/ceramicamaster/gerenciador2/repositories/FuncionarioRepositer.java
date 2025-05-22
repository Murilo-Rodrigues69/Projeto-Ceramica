package com.ceramicamaster.gerenciador2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceramicamaster.gerenciador2.entities.Funcionario;

public interface FuncionarioRepositer extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findByNomeContainingIgnoreCase(String nome);
}
