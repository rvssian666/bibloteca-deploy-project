package com.practicaJPA.bibloteca.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicaJPA.bibloteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
