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

import com.lp.examen2.model.Editorial;
import com.lp.examen2.service.EditorialService;



@RestController
@RequestMapping("/api/editorial")
public class EditorialController {
	@Autowired
	private EditorialService editorialService;
	@PostMapping("/create")
	public ResponseEntity<Editorial> save(@RequestBody Editorial editorial){
		try {
			Editorial ed = editorialService.create(new Editorial(editorial.getIdEditorial(),editorial.getEditorial(),editorial.getLibro() ));
			return new ResponseEntity<>(ed, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/all")
	public ResponseEntity<List<Editorial>> getEditorial(){
		try {
			List<Editorial> list = new ArrayList<>();
			list = editorialService.readAll();
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
	public ResponseEntity<Editorial> getPost(@PathVariable("id") long id){
		Editorial editorial = editorialService.read(id);
			if(editorial.getIdEditorial()>0) {
				return new ResponseEntity<>(editorial, HttpStatus.OK);				
			}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			editorialService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Editorial> update(@RequestBody Editorial editorial, @PathVariable("id") long id){
		try {
			Editorial pp = editorialService.read(id);
			if (pp.getIdEditorial()>0) {
				pp.setEditorial(editorial.getEditorial());
				return new ResponseEntity<>(editorialService.create(pp),HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
