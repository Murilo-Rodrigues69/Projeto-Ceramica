package com.ceramicamaster.gerenciador2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.repositories.FuncionarioRepositer;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepositer repositer;
	
	public List<Funcionario> findAll(){
		return repositer.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> obj =  repositer.findById(id);
		return obj.get();
	}
	public List<Funcionario> findByNome(String nome) {
	    return repositer.findByNomeContainingIgnoreCase(nome);
	}
}
