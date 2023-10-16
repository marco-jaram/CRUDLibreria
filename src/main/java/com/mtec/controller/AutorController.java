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

import com.mtec.model.Autor;

import com.mtec.service.IAutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

	private IAutorService autorService;
	
	@Autowired
	public AutorController(IAutorService autorService) {
		this.autorService=autorService;	
		
	}
	
	@PostMapping("/create")
	public Autor createAutor(@RequestBody Autor autor) {
		return autorService.createAutor(autor);
	}
	
	@GetMapping("/todos")
	public List<Autor>readTodos(){
		return autorService.readAutorTodos();
	}
	@GetMapping("/porId/{id}")
	public Autor readAutorPorId(@PathVariable Long id) {
		return  autorService.readAutorPorId(id);
		
	}
	
	@PutMapping("/update/{id}")
	public Autor updateAutor(@PathVariable Long id,@RequestBody Autor autorActaulizado) {
		 
		// Llama al método updateAutor del servicio para actualizar el autor
        Autor autorExistente = autorService.updateAutor(id, autorActaulizado);

        if (autorExistente == null) {
            throw new RuntimeException("Autor no encontrado con ID: " + id);
        }

        return autorExistente;
	}
	@DeleteMapping("/delete/{id}")
	public void  deleteAutor(@PathVariable Long id) {
		autorService.deleteAutor(id);
		
	}
	
	
}
