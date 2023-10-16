package com.mtec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtec.model.Editorial;
import com.mtec.repo.IEditorialRepository;

@Service
public class EditorialServiceImpl implements IEditorialService  {
@Autowired
private IEditorialRepository editorialRepository;

	@Override
	public Editorial createEditorial(Editorial editorial) {
		
		return editorialRepository.save(editorial);
	}

	@Override
	public List<Editorial> readEditorialTodos() {
		
		return editorialRepository.findAll();
	}

	@Override
	public Editorial readEditorialPorId(Long id) {
		
		return editorialRepository.findById(id).orElse(null);
	}

	@Override
	public Editorial updateEditorial(Long id, Editorial editorialActualizado) {
		Editorial editorialExiste = editorialRepository.findById(id).orElse(null);
		if (editorialExiste == null) {
			throw new RuntimeException("Editorial no encontrada mi chavo"+id);
		}
		editorialExiste.setNombreEditorial(editorialActualizado.getNombreEditorial());
		editorialExiste.setPais(editorialActualizado.getPais());
		
		return editorialRepository.save(editorialExiste);
	}

	@Override
	public void deleteEditorial(Long id) {
		editorialRepository.deleteById(id);
		
	}

	
	
}
