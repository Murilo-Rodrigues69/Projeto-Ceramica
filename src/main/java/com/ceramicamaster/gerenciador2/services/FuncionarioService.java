package com.ceramicamaster.gerenciador2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.FuncionarioRepositer;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepositer repositer;
	
	public List<Funcionario> findAll(){
		return repositer.findAll();
	}
	
	public Funcionario findById(Long id) {
		if(id==null) {
			throw new GerenciadorExceptionResolver("O campo Id não pode ser nulo");
		}
		Optional<Funcionario> obj = repositer.findById(id);
	    return obj.orElseThrow(() -> new GerenciadorExceptionResolver("Funcionário com ID " + id + " não encontrado."));
	}
	public List<Funcionario> findByNome(String nome) {
		List<Funcionario> lista = repositer.findByNomeContainingIgnoreCase(nome);

	    if (lista.isEmpty()) {
	        throw new GerenciadorExceptionResolver("Nenhum funcionário encontrado com o nome: " + nome);
	    }

	    return lista;
	}
	
	public Funcionario insert(Funcionario obj) {
		return repositer.save(obj);
	}
	
	public void delete(Long id) {
		repositer.deleteById(id);
	}
	
}
