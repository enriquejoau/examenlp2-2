package com.lp.examen2.service;
import java.util.List;
import com.lp.examen2.model.Libro;

public interface SLibro {
	Libro create (Libro libro);
	List<Libro> readAll();
	Libro read (Long id);
	void delete (Long id);
	Libro update(Libro libro);
}