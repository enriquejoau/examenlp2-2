package com.lp.examen2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.examen2.model.Autor;
import com.lp.examen2.repository.AutorRepository;
@Service
public class AutorService implements SAutor{
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public Autor create(Autor autor) {
		// TODO Auto-generated method stub
		return autorRepository.save(autor);
	}

	@Override
	public List<Autor> readAll() {
		// TODO Auto-generated method stub
		return autorRepository.findAll();
	}

	@Override
	public Autor read(Long id) {
		// TODO Auto-generated method stub
		return autorRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		autorRepository.deleteById(id);
	}

	@Override
	public Autor update(Autor autor) {
		// TODO Auto-generated method stub
		return autorRepository.save(autor);
	}

}