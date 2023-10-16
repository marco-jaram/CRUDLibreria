package com.mtec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtec.model.Tema;
import com.mtec.repo.ITemaRepository;
@Service
public class TemaServiceImpl implements ITemaService {
	private final ITemaRepository temaRepository;
	
	@Autowired
	public TemaServiceImpl(ITemaRepository temaRepository) {
		this.temaRepository=temaRepository;
	}
	

	@Override
	public Tema createTema(Tema tema) {
		return temaRepository.save(tema) ;
	}

	@Override
	public List<Tema> readTemaTodos() {
		
		return temaRepository.findAll();
	}

	@Override
	public Tema readTemaPorId(Long id) {
		return temaRepository.findById(id).orElse(null);
	}

	@Override
	public Tema updateTema(Long id, Tema temaActualizado) {
		Tema temaExistente=temaRepository.findById(id).orElse(null);
		if (temaExistente == null) {
			throw new RuntimeException("Tema no encontrado con ID: " + id);
		}
		temaExistente.setNombreTema(temaActualizado.getNombreTema());
		
		return temaRepository.save(temaExistente);
	}

	@Override
	public void deleteTema(Long id) {
		temaRepository.deleteById(id);;
		
	}

}
