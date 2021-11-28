package com.lp.examen2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor  
@Entity
@Table(name = "editorial")

public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEditorial;
	@Column(name = "editorial")
	private String editorial;
	
	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Editorial(long idEditorial, String editorial, List<Libro> libro) {
		super();
		this.idEditorial = idEditorial;
		this.editorial = editorial;
		this.libro = libro;
	}

	public long getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(long idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}




	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "editorial")
	private List<Libro> libro;



}