package com.mtec.service;

import java.util.List;

import com.mtec.model.Libro;


public interface ILibroService {
	public Libro createLibro(Libro libro);
	List<Libro>readLibroTodos();
	Libro readLibroPorId(Long id);
	public Libro updateLibro(Long id, Libro libroActualizado);
	public void deleteLibro(Long id);
}
