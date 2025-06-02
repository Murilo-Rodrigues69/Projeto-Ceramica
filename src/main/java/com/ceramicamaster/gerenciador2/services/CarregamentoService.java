package com.ceramicamaster.gerenciador2.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.exceptions.GerenciadorExceptionResolver;
import com.ceramicamaster.gerenciador2.repositories.CarregamentoRepositer;

import jakarta.persistence.EntityNotFoundException;

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
	 
	 public Carregamento insert(Carregamento obj) {
	        if (obj == null) {
	            throw new GerenciadorExceptionResolver("Os dados do Carregamento não podem ser nulos.");
	        }
			return repositer.save(obj);
		}

		public void delete(Long id) {
			if (id == null) {
				throw new GerenciadorExceptionResolver("O ID informado não pode ser nulo.");
			}

			boolean exists = repositer.existsById(id);
			if (!exists) {
				throw new GerenciadorExceptionResolver("Carregamento com ID " + id + " não encontrado para exclusão.");
			}

			try {
				repositer.deleteById(id);
			} catch (EmptyResultDataAccessException e) {
				throw new GerenciadorExceptionResolver(
						"Não foi possível deletar. Carregamento com ID " + id + " não encontrado.");
			} catch (Exception e) {
				throw new GerenciadorExceptionResolver("Erro ao tentar deletar Carregamento: " + e.getMessage());
			}

		}

		public Carregamento update(Long id, Carregamento obj) {

			if (id == null) {
				throw new GerenciadorExceptionResolver("O campo ID não pode ser nulo.");
			}

			try {
				Carregamento entity = repositer.getReferenceById(id); 
				updateData(entity, obj);
				return repositer.save(entity);

			} catch (EntityNotFoundException e) {
				throw new GerenciadorExceptionResolver("Carrgamento com ID " + id + " não encontrado.");

			} catch (IllegalArgumentException e) {
				throw new GerenciadorExceptionResolver("Erro ao atualizar Carregamento: dados inválidos.");

			} catch (Exception e) {
				throw new GerenciadorExceptionResolver("Erro inesperado ao atualizar Carregamento: " + e.getMessage());
			}
		}

		private void updateData(Carregamento entity, Carregamento obj) {
			entity.setMotorista(obj.getMotorista());
			entity.setData(obj.getData());
			entity.setMedidaDoTijolo(obj.getMedidaDoTijolo());
			entity.setQuantidade(obj.getQuantidade());
			entity.setResponsavel(obj.getResponsavel());
		
		}
}
