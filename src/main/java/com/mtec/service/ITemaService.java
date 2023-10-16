package com.mtec.service;



import java.util.List;
import com.mtec.model.Tema;

public interface ITemaService {
	public Tema createTema(Tema tema);
	List<Tema>readTemaTodos();
	Tema readTemaPorId(Long id);
	public Tema updateTema(Long id, Tema temaActualizado);
	public void deleteTema(Long id);
}
