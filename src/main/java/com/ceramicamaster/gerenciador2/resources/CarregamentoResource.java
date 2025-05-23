package com.ceramicamaster.gerenciador2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.services.CarregamentoService;



@RestController
@RequestMapping(value = "/carregamentos")
public class CarregamentoResource {
	
	@Autowired
	private CarregamentoService service;
	
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
	
	

}
