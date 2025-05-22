package com.ceramicamaster.gerenciador2.resources;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceramicamaster.gerenciador2.entities.Carregamento;
import com.ceramicamaster.gerenciador2.entities.enums.EnumCarregamento;



@RestController
@RequestMapping(value = "/Carregamento")
public class CarregamentoResource {
	
	Date data;
	
	@GetMapping
	public ResponseEntity<Carregamento> findAll(){
		Carregamento c = new Carregamento(1L, "Mimosa", 4500, "9x19x19", data, EnumCarregamento.Pezinho);
		return ResponseEntity.ok().body(c);
	}

}
