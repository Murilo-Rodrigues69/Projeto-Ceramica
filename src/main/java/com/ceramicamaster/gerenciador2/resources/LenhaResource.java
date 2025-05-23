package com.ceramicamaster.gerenciador2.resources;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.entities.enums.EnumLenha;



@RestController
@RequestMapping(value = "/Lenha")
public class LenhaResource {

	
	@GetMapping
	public ResponseEntity<Lenha> findAll(){
		Lenha l = new Lenha(1L, "Joao ricardo", "Lenha do mato", "Ruim", 2.55, 1750.00, EnumLenha.Vilson, Instant.now());
		return ResponseEntity.ok().body(l);
	}
}
