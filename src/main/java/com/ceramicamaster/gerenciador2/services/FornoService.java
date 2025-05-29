package com.ceramicamaster.gerenciador2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Forno;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.FornoRepositer;

@Service
public class FornoService {

	@Autowired
	private FornoRepositer repositer;

	public List<Forno> findAll() {
		return repositer.findAll();
	}

	public Forno findById(Long id) {
		if(id==null) {
			throw new GerenciadorExceptionResolver("O campo Id não pode ser nulo");
		}
		Optional<Forno> obj = repositer.findById(id);
	    return obj.orElseThrow(() -> new GerenciadorExceptionResolver("Forno com ID " + id + " não encontrado."));
	}

	public Forno findByNumero(Integer numero) {
		if (numero == null) {
			throw new GerenciadorExceptionResolver("O número do forno não pode ser nulo");
		}

		return repositer.findByNumeroDoForno(numero)
				.orElseThrow(() -> new GerenciadorExceptionResolver("Forno com número " + numero + " não encontrado"));
	}

	public List<Forno> buscarPorDataEntre(LocalDate inicio, LocalDate fim) {
		List<Forno> lista = repositer.findByDataDeEntradaBetween(inicio, fim);
		if(lista.isEmpty()) {
			throw new GerenciadorExceptionResolver("Nenhum Forno encontrada para o as datas informadas inicio:"+inicio+" fim:"+fim);
		}
		return lista;
		
	}
}
