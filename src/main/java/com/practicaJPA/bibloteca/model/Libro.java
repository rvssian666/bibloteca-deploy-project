package com.practicaJPA.bibloteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String titulo;
	private String autor;
	private String isbn;
	private Integer anio_publicacion;

	public Libro() {
		super();
	}

	public Libro(Integer id, String titulo, String autor, String isbn, Integer anio_publicacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.anio_publicacion = anio_publicacion;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAnio_publicacion() {
		return anio_publicacion;
	}

	public void setAnio_publicacion(Integer anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", anio_publicacion="
				+ anio_publicacion + "]";
	}

}
