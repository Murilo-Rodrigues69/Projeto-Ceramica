package com.ceramicamaster.gerenciador2.resources;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.entities.enums.EnumLenha;



@RestController
@RequestMapping(value = "/Lenha")
public class LenhaResource {

	Date data;
	
	@GetMapping
	public ResponseEntity<Lenha> findAll(){
		Lenha l = new Lenha(1L, "Jose Maria", "Lenha do mato", "Lenha ruim", 2.77, 1514.98,EnumLenha.Marcio);
		return ResponseEntity.ok().body(l);
	}
}
