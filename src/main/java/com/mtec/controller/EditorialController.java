package com.mtec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mtec.model.Editorial;
import com.mtec.service.IEditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController {
	private IEditorialService editorialService;

	@Autowired
	public EditorialController(IEditorialService editorialService) {
		this.editorialService = editorialService;

	}

	@PostMapping("/create")
	public Editorial createEditorial(@RequestBody Editorial editorial) {
		return editorialService.createEditorial(editorial);
	}

	@GetMapping("/readTodos")
	public List<Editorial> readEditorialTodos() {
		return editorialService.readEditorialTodos();
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Editorial> readEditorialPorId(@PathVariable Long id) {
		Editorial editorial = editorialService.readEditorialPorId(id);

		if (editorial != null) {
			return ResponseEntity.ok(editorial);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/update/{id}")
	public Editorial updateEditorial(@PathVariable Long id, @RequestBody Editorial editorialActaulizado) {

		// Llama al método updateEditorial del servicio para actualizar el editorial
		Editorial editorialExistente = editorialService.updateEditorial(id, editorialActaulizado);

		if (editorialExistente == null) {
			throw new RuntimeException("Autor no encontrado con ID: " + id);
		}

		return editorialExistente;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEditorial(@PathVariable Long id) {
		editorialService.deleteEditorial(id);
	}
}
