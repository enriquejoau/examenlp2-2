package com.lp.examen2.service;

import java.util.List;

import com.lp.examen2.model.Autor;

public interface SAutor {
	Autor create (Autor autor);
	List<Autor> readAll();
	Autor read (Long id);
	void delete (Long id);
	Autor update(Autor autor);
}
