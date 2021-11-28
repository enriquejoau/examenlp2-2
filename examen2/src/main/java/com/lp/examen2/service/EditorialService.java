package com.lp.examen2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.examen2.model.Editorial;
import com.lp.examen2.repository.EditorialRepository;
@Service
public class EditorialService implements SEditorial {
	@Autowired
	private EditorialRepository editorialRepository;
	
	@Override
	public Editorial create(Editorial editorial) {
		// TODO Auto-generated method stub
		return editorialRepository.save(editorial);
	}

	@Override
	public List<Editorial> readAll() {
		// TODO Auto-generated method stub
		return editorialRepository.findAll();
	}

	@Override
	public Editorial read(Long id) {
		// TODO Auto-generated method stub
		return editorialRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		editorialRepository.deleteById(id);
	}

	@Override
	public Editorial update(Editorial editorial) {
		// TODO Auto-generated method stub
		return editorialRepository.save(editorial);
	}

}