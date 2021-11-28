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

import com.lp.examen2.model.Libro;
import com.lp.examen2.service.LibroService;

@RestController
@RequestMapping("/api/libro")
public class LibroController {
	@Autowired
	private LibroService libroService;
	@PostMapping("/create")
	public ResponseEntity<Libro> save(@RequestBody Libro libro){
		try {
			Libro li = libroService.create(new Libro(libro.getIdLibro(),libro.getTitulo(),libro.getPaginas(),libro.getDescripcion(),libro.getEditorial(),libro.getAutor()));
			return new ResponseEntity<>(li, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/all")
	public ResponseEntity<List<Libro>> getLibro(){
		try {
			List<Libro> list = new ArrayList<>();
			list = libroService.readAll();
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
	public ResponseEntity<Libro> getPost(@PathVariable("id") long id){
		Libro libro = libroService.read(id);
			if(libro.getIdLibro()>0) {
				return new ResponseEntity<>(libro, HttpStatus.OK);				
			}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			libroService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Libro> update(@RequestBody Libro libro, @PathVariable("id") long id){
		try {
			Libro pp = libroService.read(id);
			if (pp.getIdLibro()>0) {
				pp.setTitulo(libro.getTitulo());
				pp.setPaginas(libro.getPaginas());
				pp.setDescripcion(libro.getDescripcion());
				return new ResponseEntity<>(libroService.create(pp),HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
