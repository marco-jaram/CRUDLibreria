package com.mtec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtec.model.Libro;
import com.mtec.repo.ILibroRepository;

@Service
public class LibroServiceImpl implements ILibroService{
	
	private final ILibroRepository libroRespository;
	@Autowired
	public LibroServiceImpl(ILibroRepository libroRepository) {
		this.libroRespository =libroRepository;
	}

	@Override
	public Libro createLibro(Libro libro) {
		
		return libroRespository.save(libro);
	}

	@Override
	public List<Libro> readLibroTodos() {
		
		return libroRespository.findAll();
	}

	@Override
	public Libro readLibroPorId(Long id) {
		
		return libroRespository.findById(id).orElse(null);
	}

	@Override
	public Libro updateLibro(Long id, Libro libroActualizado) {
	    Optional<Libro> libroExistenteOptional = libroRespository.findById(id);
	    
	    if (libroExistenteOptional.isPresent()) {
	        Libro libroExistente = libroExistenteOptional.get();
	        
	        // Actualiza los campos del libro existente con los valores proporcionados
	        libroExistente.setTitulo(libroActualizado.getTitulo());
	        libroExistente.setAutor(libroActualizado.getAutor());
	        libroExistente.setEditorial(libroActualizado.getEditorial());
	        libroExistente.setTema(libroActualizado.getTema());
	        libroExistente.setExistencia(libroActualizado.getExistencia());
	        libroExistente.setPrecio(libroActualizado.getPrecio());
	        
	        // Guarda el libro actualizado en la base de datos
	        return libroRespository.save(libroExistente);
	    } else {
	        throw new RuntimeException("El libro con ID " + id + " no se encontró en la base de datos");
	    }
	}

	
	@Override
	public void deleteLibro(Long id) {
		libroRespository.deleteById(id);
		
	}

}
