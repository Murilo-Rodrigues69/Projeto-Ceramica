package com.ceramicamaster.gerenciador2.resources;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceramicamaster.gerenciador2.entities.Funcionario;

@RestController
@RequestMapping(value = "/Funcionarios")
public class FuncionarioResource {

	Date data;
	@GetMapping
	public ResponseEntity<Funcionario> findAll(){
		Funcionario f = new Funcionario(1L, "Murilo Oliveira Rodrigues",data , "61982201716", "61991845071", 4000.00);
		return ResponseEntity.ok().body(f);
	}
}
