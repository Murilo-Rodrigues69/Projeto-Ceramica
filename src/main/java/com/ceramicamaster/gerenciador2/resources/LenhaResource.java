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

import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.entities.Lenha;
import com.ceramicamaster.gerenciador2.services.LenhaService;

@RestController
@RequestMapping(value = "/Lenha")
public class LenhaResource {

	@Autowired
	private LenhaService service;

	@GetMapping
	public ResponseEntity<List<Lenha>> findAll() {
		List<Lenha> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Lenha> findById(@PathVariable Long id) {
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



	@PostMapping
	public ResponseEntity<Lenha> insert(@RequestBody Lenha Lenha) {
		Lenha salvo = service.insert(Lenha);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Lenha> update(@PathVariable Long id, @RequestBody Lenha obj) {
		Lenha atualizado = service.update(id, obj);
		return ResponseEntity.ok(atualizado);
	}
}
