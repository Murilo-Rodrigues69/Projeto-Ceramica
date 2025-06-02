package com.ceramicamaster.gerenciador2.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.ceramicamaster.gerenciador2.entities.Forno;

import com.ceramicamaster.gerenciador2.services.FornoService;


@RestController
@RequestMapping(value = "/Forno")
public class FornoResource {

	@Autowired
	FornoService service;
	
	@GetMapping
	public ResponseEntity <List<Forno>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Forno> findById(@PathVariable Long id){
		Forno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping("/numero")
    public ResponseEntity<Forno> findByNumero(@RequestParam Integer numeroDoForno) {
        return ResponseEntity.ok(service.findByNumero(numeroDoForno));
    }
	@GetMapping("/data")
    public ResponseEntity<List<Forno>> buscarPorDataEntre(
    		@RequestParam("inicio") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate inicio,
    		@RequestParam("fim") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fim) {
		List<Forno> lista = service.buscarPorDataEntre(inicio, fim);
	    return ResponseEntity.ok(lista);
	}
	@PostMapping
	public ResponseEntity<Forno> insert(@RequestBody Forno forno) {
	    Forno salvo = service.insert(forno);
	    return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
	    service.delete(id);
	    return ResponseEntity.noContent().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<Forno> update(@PathVariable Long id, @RequestBody Forno obj) {
	    Forno atualizado = service.update(id, obj);
	    return ResponseEntity.ok(atualizado);
	}
	
}
