package com.ceramicamaster.gerenciador2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.LenhaRepositer;

import jakarta.persistence.EntityNotFoundException;

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
	
	public Lenha update(Long id, Lenha obj) {
	    if (id == null) {
	        throw new GerenciadorExceptionResolver("O campo ID não pode ser nulo.");
	    }

	    try {
	        Lenha entity = repositer.getReferenceById(id);
	        updateData(entity, obj);
	        return repositer.save(entity);
	    } catch (EntityNotFoundException e) {
	        throw new GerenciadorExceptionResolver("Lenha com ID " + id + " não encontrado.");
	    } catch (IllegalArgumentException e) {
	        throw new GerenciadorExceptionResolver("Erro ao atualizar Lenha: dados inválidos.");
	    } catch (Exception e) {
	        throw new GerenciadorExceptionResolver("Erro inesperado ao atualizar Lenha: " + e.getMessage());
	    }
	}
	private void updateData(Lenha entity, Lenha obj) {
	    entity.setData(obj.getData());
	    entity.setfornecedor(obj.getfornecedor());
	    entity.setLenha(obj.getLenha());
	    entity.setMedidaLenha(obj.getMedidaLenha());
	    entity.setResponsavel(obj.getResponsavel());
	    entity.setTipo(obj.getTipo());
	    entity.setTotal(obj.getTotal());
	}
	public Lenha insert(Lenha Lenha) {
	    try {
	        return repositer.save(Lenha);
	    } catch (Exception e) {
	        throw new GerenciadorExceptionResolver("Erro ao inserir Lenha: " + e.getMessage());
	    }
	}
	public void delete(Long id) {
	    try {
	        repositer.deleteById(id);
	    } catch (EmptyResultDataAccessException e) {
	        throw new GerenciadorExceptionResolver("Lenha com ID " + id + " não encontrado.");
	    } catch (Exception e) {
	        throw new GerenciadorExceptionResolver("Erro inesperado ao deletar Lenha: " + e.getMessage());
	    }
	}
}
