package com.practicaJPA.bibloteca;

import org.hibernate.metamodel.model.domain.internal.DomainModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicaJPA.bibloteca.Repository.LibroRepository;
import com.practicaJPA.bibloteca.Repository.SocioRepository;
import com.practicaJPA.bibloteca.model.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class BiblotecaApplication implements CommandLineRunner {
	@Autowired
	LibroRepository libroRepo;
	@Autowired
	SocioRepository socioRepo;

	public static void main(String[] args) {
		SpringApplication.run(BiblotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";

	}

	// Metodos que devuelven el listado de cada entidad
	@GetMapping("/listadoLibros")
	public String listarLibros(Model model) {
		model.addAttribute("listaLibros", libroRepo.findAll());
		return "listadoLibros";
	}

	@GetMapping("/listadoSocios")
	public String listarSocios(Model model) {
		model.addAttribute("listaSocios", socioRepo.findAll());
		return "listadoSocios";
	}

	// Altas GET y POST por cada Entidad

	@GetMapping("/altaLibro")
	public String mostrarFormLibro(Model model) {

		model.addAttribute("libro", new Libro());
		return "form-libro";
	}

	@PostMapping("/altalibro")
	public String saveLibro(Libro libro) {
		libroRepo.save(libro);
		return "redirect/listadoLibros";
	}

	@GetMapping("/altaSocio")
	public String mostrarAltaSocio(Model model) {
		model.addAttribute("socio", new Socio());
		return "form-socio";
	}

	@PostMapping("/altaSocio")
	public String saveSocio(Socio socio) {
		socioRepo.save(socio);
		return "redirect/listadoSocios";
	}

}
