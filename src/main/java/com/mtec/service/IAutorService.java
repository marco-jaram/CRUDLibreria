package com.mtec.service;

import java.util.List;


import com.mtec.model.Autor;

public interface IAutorService {
	public Autor createAutor(Autor autor);
	List<Autor>readAutorTodos();
	Autor readAutorPorId(Long id);
	public Autor updateAutor(Long id, Autor autorActualizado);
	public void deleteAutor(Long id);
	

}
