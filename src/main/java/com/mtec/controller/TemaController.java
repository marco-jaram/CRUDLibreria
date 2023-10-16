package com.mtec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtec.model.Tema;
import com.mtec.service.ITemaService;

@RestController
@RequestMapping("/tema")
public class TemaController {

	private final ITemaService temaService;
	@Autowired
	public TemaController(ITemaService temaService) {
		this.temaService=temaService;
	}
	@PostMapping("/create")
	public Tema createTema(@RequestBody Tema tema) {
		return temaService.createTema(tema);
		
	}
	@GetMapping("/readTodos")
	public List<Tema> readTemaTodos(){
		return temaService.readTemaTodos();
	}
	
	@GetMapping("/readPorId")
	public Tema readTemaPoId(@PathVariable Long id) {
		return temaService.readTemaPorId(id);
	}
	
	@PutMapping("/update/{id}")
	public Tema updateTemaPorId(@PathVariable Long id, @RequestBody Tema temaActaulizado ) {
		Tema temaExistente= temaService.updateTema(id, temaActaulizado);
		if (temaExistente == null) {
			throw new RuntimeException("Tema no encontrado con ID: " + id);
		}
		
		return temaExistente;
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTema(@PathVariable Long id) {
		temaService.deleteTema(id);
	}
	
	
}
