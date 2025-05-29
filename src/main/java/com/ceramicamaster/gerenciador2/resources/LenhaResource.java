package com.ceramicamaster.gerenciador2.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.services.LenhaService;



@RestController
@RequestMapping(value = "/Lenha")
public class LenhaResource {

	@Autowired
	private LenhaService service;
	
	@GetMapping
	public ResponseEntity<List <Lenha>> findAll(){
		List<Lenha> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Lenha> findById(@PathVariable Long id){
		Lenha obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping("/buscar")
	public ResponseEntity<List<Lenha>> buscarPorNome(@RequestParam String Fornecedor) {
	    List<Lenha> fornecedor = service.findByFornecedorContainingIgnoreCase(Fornecedor);
	    return ResponseEntity.ok().body(fornecedor);
	}
	@GetMapping("/data")
    public ResponseEntity<List<Lenha>> buscarPorDataEntre(
    		@RequestParam("inicio") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate inicio,
    		@RequestParam("fim") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fim) {
		List<Lenha> lista = service.buscarPorDataEntre(inicio, fim);
	    return ResponseEntity.ok(lista);
    }
}
