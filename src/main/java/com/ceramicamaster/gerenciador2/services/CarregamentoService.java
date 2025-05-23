package com.ceramicamaster.gerenciador2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.repositories.CarregamentoRepositer;

@Service
public class CarregamentoService {

	@Autowired
	private CarregamentoRepositer repositer;
	
	public List<Carregamento> findAll(){
		return repositer.findAll();
	}
	
	public Carregamento findById(Long id) {
		Optional<Carregamento> obj =  repositer.findById(id);
		return obj.get();
	}
	public List<Carregamento> findByMotorista(String motorista) {
	    return repositer.findByMotoristaNomeContainingIgnoreCase(motorista);
	}
}
