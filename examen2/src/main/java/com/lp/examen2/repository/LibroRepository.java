package com.lp.examen2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp.examen2.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

}