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
@Table(name = "autor")

public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAutor;
	@Column(name = "nombres")
	private String nombres;
	@Column(name = "apellidos")
	private String apellidos;
	
	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Autor(long idAutor, String nombres, String apellidos, List<Libro> libro) {
		super();
		this.idAutor = idAutor;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.libro = libro;
	}

	public long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Libro> getLibro() {
		return libro;
	}

	public void setLibro(List<Libro> libro) {
		this.libro = libro;
	}



	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
	private List<Libro> libro;
}