package com.lp.examen2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lp.examen2.model.Libro;
import com.lp.examen2.repository.LibroRepository;

@Service
public class LibroService implements SLibro {
	@Autowired
	private LibroRepository libroRepository;

	@Override
	public Libro create(Libro s) {
		// TODO Auto-generated method stub
		return libroRepository.save(s); 
	}

	@Override
	public List<Libro> readAll() {
		// TODO Auto-generated method stub
		return libroRepository.findAll();  
	}

	@Override
	public Libro read(Long id) {
		// TODO Auto-generated method stub
		return libroRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroRepository.deleteById(id);
	}

	@Override
	public Libro update(Libro libro) {
		// TODO Auto-generated method stub
		return libroRepository.save(libro);
	}

}