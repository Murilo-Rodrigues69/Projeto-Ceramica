package com.ceramicamaster.gerenciador2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Forno;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.FornoRepositer;

import jakarta.persistence.EntityNotFoundException;

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
	public Forno update(Long id, Forno obj) {
	    if (id == null) {
	        throw new GerenciadorExceptionResolver("O campo ID não pode ser nulo.");
	    }

	    try {
	        Forno entity = repositer.getReferenceById(id);
	        updateData(entity, obj);
	        return repositer.save(entity);
	    } catch (EntityNotFoundException e) {
	        throw new GerenciadorExceptionResolver("Forno com ID " + id + " não encontrado.");
	    } catch (IllegalArgumentException e) {
	        throw new GerenciadorExceptionResolver("Erro ao atualizar Forno: dados inválidos.");
	    } catch (Exception e) {
	        throw new GerenciadorExceptionResolver("Erro inesperado ao atualizar Forno: " + e.getMessage());
	    }
	}
	private void updateData(Forno entity, Forno obj) {
	    entity.setNumeroDoForno(obj.getNumeroDoForno());
	    entity.setDataDeEntrada(obj.getDataDeEntrada());
	    entity.setDataDeSaida(obj.getDataDeSaida());
	    entity.setEquipeForno(obj.getEquipeForno());
	}
	public Forno insert(Forno forno) {
	    try {
	        return repositer.save(forno);
	    } catch (Exception e) {
	        throw new GerenciadorExceptionResolver("Erro ao inserir forno: " + e.getMessage());
	    }
	}
	public void delete(Long id) {
	    try {
	        repositer.deleteById(id);
	    } catch (EmptyResultDataAccessException e) {
	        throw new GerenciadorExceptionResolver("Forno com ID " + id + " não encontrado.");
	    } catch (Exception e) {
	        throw new GerenciadorExceptionResolver("Erro inesperado ao deletar Forno: " + e.getMessage());
	    }
	}
}
