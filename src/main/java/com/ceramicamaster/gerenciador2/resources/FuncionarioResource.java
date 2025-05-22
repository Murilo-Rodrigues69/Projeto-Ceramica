package com.ceramicamaster.gerenciador2.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceramicamaster.gerenciador2.entities.Funcionario;
import com.ceramicamaster.gerenciador2.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List <Funcionario>> findAll(){
		List<Funcionario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping("/buscar")
	public ResponseEntity<List<Funcionario>> buscarPorNome(@RequestParam String nome) {
	    List<Funcionario> funcionarios = service.findByNome(nome);
	    return ResponseEntity.ok(funcionarios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Funcionario> findById(@PathVariable Long id){
		Funcionario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
