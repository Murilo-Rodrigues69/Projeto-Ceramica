package com.ceramicamaster.gerenciador2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.CarregamentoRepositer;

@Service
public class CarregamentoService {

	@Autowired
	private CarregamentoRepositer repositer;
	
	public List<Carregamento> findAll(){
		return repositer.findAll();
	}
	
	public Carregamento findById(Long id) {
		if(id==null) {
			throw new GerenciadorExceptionResolver("O campo Id não pode ser nulo");
		}
		Optional<Carregamento> obj = repositer.findById(id);
	    return obj.orElseThrow(() -> new GerenciadorExceptionResolver("Carregamento com ID " + id + " não encontrado."));
	}
	
	public List<Carregamento> findByMotorista(String motorista) {
	    List<Carregamento> lista = repositer.findByMotoristaNomeContainingIgnoreCase(motorista);
	    if(lista.isEmpty()) {
	    	throw new GerenciadorExceptionResolver("nenhum motorista encontrada com esse nome:"+motorista);
	    }
	    return lista;
	}
	
	 public List<Carregamento> buscarPorDataEntre(LocalDate inicio, LocalDate fim) {
		 List<Carregamento> lista = repositer.findByDataBetween(inicio, fim);
		 if(lista.isEmpty()) {
			 throw new GerenciadorExceptionResolver("nenhum carregamento encontrado com esse data inicio:"+inicio+" fim:"+fim);
		 }
		 return lista;
	    }
}
