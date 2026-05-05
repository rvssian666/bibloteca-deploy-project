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
	private Integer anioPublicacion;

	public Libro() {
		super();
	}

	public Libro(Integer id, String titulo, String autor, String isbn, Integer anioPublicacion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.anioPublicacion = anioPublicacion;
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

	public Integer getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(Integer anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", anioPublicacion="
				+ anioPublicacion + "]";
	}

}
