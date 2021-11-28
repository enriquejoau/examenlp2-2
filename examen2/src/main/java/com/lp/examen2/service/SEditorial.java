package com.lp.examen2.service;
import java.util.List;


import com.lp.examen2.model.Editorial;

public interface SEditorial {
	Editorial create (Editorial editorial);
	List<Editorial> readAll();
	Editorial read (Long id);
	void delete (Long id);
	Editorial update(Editorial editorial);
}
