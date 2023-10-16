package com.mtec.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtec.model.Autor;
import com.mtec.repo.IAutorRepository;
@Service
public class AutorServiceImpl implements IAutorService {
	private final IAutorRepository autorRepository; 
    @Autowired
    public AutorServiceImpl(IAutorRepository autorRepository) { 
        this.autorRepository = autorRepository;
    }
	@Override
	public Autor createAutor(Autor autor) {
		 return autorRepository.save(autor);
	}

	@Override
	public List<Autor> readAutorTodos() {
		 return autorRepository.findAll();
	}

	@Override
	public Autor readAutorPorId(Long id) {
		return autorRepository.findById(id).orElse(null);
	}

	@Override
	public Autor updateAutor(Long id, Autor autorActualizado) {
		// Primero, verifica si el autor con el ID proporcionado existe en la base de datos
        Autor autorExistente = autorRepository.findById(id).orElse(null);

        // Si el autor no existe, lanza una excepción o maneja el error según tus requerimientos
        if (autorExistente == null) {
            throw new RuntimeException("Autor no encontrado con ID: " + id);
        }

        // Actualiza los campos del autor existente con los datos del autor actualizado
        autorExistente.setNombreAutor(autorActualizado.getNombreAutor());
        autorExistente.setApellido(autorActualizado.getApellido());
        // Aquí puedes actualizar otros campos según sea necesario

        // Guarda el autor actualizado en la base de datos
        return autorRepository.save(autorExistente);
    }

	

	@Override
	public void deleteAutor(Long id) {
		autorRepository.deleteById(id);
		
	}
	

}
