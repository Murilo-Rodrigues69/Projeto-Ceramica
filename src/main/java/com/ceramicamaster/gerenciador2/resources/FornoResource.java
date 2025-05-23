package com.ceramicamaster.gerenciador2.resources;

import java.time.Instant;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ceramicamaster.gerenciador2.entities.Forno;


@RestController
@RequestMapping(value = "/Forno")
public class FornoResource {

	Date data;
	
	@GetMapping
	public ResponseEntity<Forno> findAll(){
		Forno f = new Forno(1L, 4, Instant.now(), Instant.now(), "Equipe 10");
		return ResponseEntity.ok().body(f);
	}
}
