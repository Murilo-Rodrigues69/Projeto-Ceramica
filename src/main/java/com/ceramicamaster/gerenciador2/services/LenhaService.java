package com.ceramicamaster.gerenciador2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.LenhaRepositer;

@Service
public class LenhaService {

	@Autowired
	private LenhaRepositer repositer;

	public List<Lenha> findAll() {
		return repositer.findAll();
	}

	public Lenha findById(Long id) {
		if (id == null) {
			throw new GerenciadorExceptionResolver("O campo Id não pode ser nulo");
		}
		Optional<Lenha> obj = repositer.findById(id);
		return obj.orElseThrow(() -> new GerenciadorExceptionResolver("Lenha com ID " + id + " não encontrado."));
	}

	public List<Lenha> findByFornecedorContainingIgnoreCase(String Fornecedor) {
		List<Lenha> lista = repositer.findByFornecedorContainingIgnoreCase(Fornecedor);

		if (lista.isEmpty()) {
			throw new GerenciadorExceptionResolver("Nenhuma lenha encontrada para o fornecedor: " + Fornecedor);
		}

		return lista;
	}

	public List<Lenha> buscarPorDataEntre(LocalDate inicio, LocalDate fim) {
		List<Lenha> lista = repositer.findByDataBetween(inicio, fim);
		
		if(lista.isEmpty()) {
			throw new GerenciadorExceptionResolver("Nenhuma lenha encontrada para o as datas informadas inicio:"+inicio+" fim:"+fim);
		}

		return lista;
	}
}
