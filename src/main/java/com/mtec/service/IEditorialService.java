package com.mtec.service;

import java.util.List;



import com.mtec.model.Editorial;

public interface IEditorialService {
	public Editorial createEditorial(Editorial editorial);
	List<Editorial>readEditorialTodos();
	Editorial readEditorialPorId(Long id);
	public Editorial updateEditorial(Long id, Editorial editorialActualizado);
	public void deleteEditorial(Long id);
}
