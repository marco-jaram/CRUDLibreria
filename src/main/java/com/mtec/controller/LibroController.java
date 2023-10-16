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

import com.mtec.model.Libro;
import com.mtec.service.ILibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {

	private final ILibroService libroService;

	@Autowired
	public LibroController(ILibroService libroService) {
		this.libroService = libroService;
	}

	@PostMapping("/create")
	public Libro createLibro(@RequestBody Libro libro) {
		return libroService.createLibro(libro);
	}

	@GetMapping("/readTodos")
    public List<Libro> obtenerTodosLosLibros() {
        return libroService.readLibroTodos() ;
    }

	@GetMapping("/readId/{id}")
	public Libro obtenerLibroPorId(@PathVariable Long id) {
		return libroService.readLibroPorId(id);
	}


	@PutMapping("/update/{id}")
	public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libroActualizado) {
	    Libro libroExistente = libroService.updateLibro(id, libroActualizado);
	    if (libroExistente != null) {
	        libroExistente.setTitulo(libroActualizado.getTitulo());
	        libroExistente.setAutor(libroActualizado.getAutor());
	        libroExistente.setEditorial(libroActualizado.getEditorial());
	        libroExistente.setTema(libroActualizado.getTema());
	        libroExistente.setExistencia(libroActualizado.getExistencia());
	        libroExistente.setPrecio(libroActualizado.getPrecio());
	        return libroService.updateLibro(id, libroExistente);
	    } else {
	        // Manejo de error si el libro no existe
	        throw new RuntimeException("Libro no encontrado con ID: " + id);
	    }
	}

@DeleteMapping("/eliminar/{id}")
	public void eliminarLibro(@PathVariable Long id) {
		libroService.deleteLibro(id);
	}
}
