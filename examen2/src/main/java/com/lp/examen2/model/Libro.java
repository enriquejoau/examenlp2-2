package com.lp.examen2.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor  
@Entity
@Table(name = "libro")

public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLibro;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "paginas")
	private int paginas;
	@Column(name = "descripcion")
	private String descripcion; 
	
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Libro(long idLibro, String titulo, int paginas, String descripcion, Editorial editorial, Autor autor) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.paginas = paginas;
		this.descripcion = descripcion;
		this.editorial = editorial;
		this.autor = autor;
	}
	
	public long getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="editorial_id",referencedColumnName = "idEditorial")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Editorial editorial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="autor_id",referencedColumnName = "idAutor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Autor autor;
}
