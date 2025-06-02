package com.ceramicamaster.gerenciador2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.FuncionarioRepositer;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepositer repositer;

	public List<Funcionario> findAll() {
		return repositer.findAll();
	}

	public Funcionario findById(Long id) {
		if (id == null) {
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
        if (obj == null) {
            throw new GerenciadorExceptionResolver("Os dados do funcionário não podem ser nulos.");
        }
		return repositer.save(obj);
	}

	public void delete(Long id) {
		if (id == null) {
			throw new GerenciadorExceptionResolver("O ID informado não pode ser nulo.");
		}

		boolean exists = repositer.existsById(id);
		if (!exists) {
			throw new GerenciadorExceptionResolver("Funcionário com ID " + id + " não encontrado para exclusão.");
		}

		try {
			repositer.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new GerenciadorExceptionResolver(
					"Não foi possível deletar. Funcionário com ID " + id + " não encontrado.");
		} catch (Exception e) {
			throw new GerenciadorExceptionResolver("Erro ao tentar deletar funcionário: " + e.getMessage());
		}

	}

	public Funcionario update(Long id, Funcionario obj) {

		if (id == null) {
			throw new GerenciadorExceptionResolver("O campo ID não pode ser nulo.");
		}

		try {
			Funcionario entity = repositer.getReferenceById(id); 
			updateData(entity, obj);
			return repositer.save(entity);

		} catch (EntityNotFoundException e) {
			throw new GerenciadorExceptionResolver("Funcionário com ID " + id + " não encontrado.");

		} catch (IllegalArgumentException e) {
			throw new GerenciadorExceptionResolver("Erro ao atualizar funcionário: dados inválidos.");

		} catch (Exception e) {
			throw new GerenciadorExceptionResolver("Erro inesperado ao atualizar funcionário: " + e.getMessage());
		}
	}

	private void updateData(Funcionario entity, Funcionario obj) {
		entity.setNome(obj.getNome());
		entity.setPix(obj.getPix());
		entity.setDataDeEntrada(obj.getDataDeEntrada());
		entity.setWhatsapp(obj.getWhatsapp());
		entity.setSalario(obj.getSalario());

	}

}
