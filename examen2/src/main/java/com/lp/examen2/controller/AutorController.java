package com.lp.examen2.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp.examen2.model.Autor;
import com.lp.examen2.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorController {
	@Autowired
	private AutorService autorService;
	@PostMapping("/create")
	public ResponseEntity<Autor> save(@RequestBody Autor autor){
		try {
			Autor au = autorService.create(new Autor(autor.getIdAutor(),autor.getNombres(),autor.getApellidos(),autor.getLibro()));
			return new ResponseEntity<>(au, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/all")
	public ResponseEntity<List<Autor>> getAutor(){
		try {
			List<Autor> list = new ArrayList<>();
			list = autorService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);	 			
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Autor> getPost(@PathVariable("id") long id){
		Autor autor = autorService.read(id);
			if(autor.getIdAutor()>0) {
				return new ResponseEntity<>(autor, HttpStatus.OK);				
			}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			autorService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Autor> update(@RequestBody Autor autor, @PathVariable("id") long id){
		try {
			Autor pp = autorService.read(id);
			if (pp.getIdAutor()>0) {
				pp.setNombres(autor.getNombres());
				pp.setApellidos(autor.getApellidos());
				return new ResponseEntity<>(autorService.create(pp),HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
