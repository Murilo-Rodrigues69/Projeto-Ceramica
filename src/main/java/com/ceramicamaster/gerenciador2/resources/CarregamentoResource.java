package com.ceramicamaster.gerenciador2.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.AotInitializerNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ceramicamaster.gerenciador2.dto.CarregamentoDTO;
import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.entities.enums.EnumCarregamento;
import com.ceramicamaster.gerenciador2.repositories.FuncionarioRepositer;
import com.ceramicamaster.gerenciador2.services.CarregamentoService;

import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping(value = "/carregamentos")
public class CarregamentoResource {
	
	@Autowired
	private CarregamentoService service;
	
	@Autowired
    private FuncionarioRepositer funcionarioRepo;
	
	@GetMapping
	public ResponseEntity<List <Carregamento>> findAll(){
		List<Carregamento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping("/buscar")
	public ResponseEntity<List<Carregamento>> buscarPorMotorista(@RequestParam String motorista) {
	    List<Carregamento> Carregamentos = service.findByMotorista(motorista);
	    return ResponseEntity.ok(Carregamentos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Carregamento> findById(@PathVariable Long id){
		Carregamento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/data")
    public ResponseEntity<List<Carregamento>> buscarEntreDatas(
    		@RequestParam("inicio") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate inicio,
    		@RequestParam("fim") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fim) {
        return ResponseEntity.ok(service.buscarPorDataEntre(inicio, fim));
    }
	
	@PostMapping
	public ResponseEntity<Carregamento> insert(@RequestBody CarregamentoDTO dto) {
	    Funcionario motorista = funcionarioRepo.findById(dto.getMotoristaId())
	        .orElseThrow(() -> new AotInitializerNotFoundException(null, "Motorista com ID " + dto.getMotoristaId() + " não encontrado"));

	    Carregamento carregamento = new Carregamento();
	    carregamento.setMotorista(motorista);
	    carregamento.setMedidaDoTijolo(dto.getMedidaDoTijolo());
	    carregamento.setData(dto.getData()); 
	    carregamento.setQuantidade(dto.getQuantidade());
	    carregamento.setResponsavel(EnumCarregamento.valueOff(dto.getResponsavel()));

	    carregamento = service.insert(carregamento);
	    return ResponseEntity.status(HttpStatus.CREATED).body(carregamento);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Carregamento> update(@PathVariable Long id, @RequestBody CarregamentoDTO dto) {
	    Funcionario motorista = funcionarioRepo.findById(dto.getMotoristaId())
	        .orElseThrow(() -> new EntityNotFoundException("Motorista com ID " + dto.getMotoristaId() + " não encontrado"));

	    Carregamento obj = new Carregamento();
	    obj.setMotorista(motorista);
	    obj.setMedidaDoTijolo(dto.getMedidaDoTijolo());
	    obj.setData(dto.getData());
	    obj.setQuantidade(dto.getQuantidade());
	    obj.setResponsavel(EnumCarregamento.valueOff(dto.getResponsavel()));

	    Carregamento atualizado = service.update(id, obj);
	    return ResponseEntity.ok(atualizado);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable  Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
