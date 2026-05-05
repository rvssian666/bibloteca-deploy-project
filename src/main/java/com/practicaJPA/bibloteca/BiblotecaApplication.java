package com.practicaJPA.bibloteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicaJPA.bibloteca.Repository.LibroRepository;
import com.practicaJPA.bibloteca.Repository.SocioRepository;
import com.practicaJPA.bibloteca.model.*;

@SpringBootApplication
@Controller
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
	}
	@GetMapping("/")
	public String home() {
	    return "redirect:/inicio";
	}

	@GetMapping("/inicio")
	public String inicio() {
		return "inicio";
	}

	@GetMapping("/listadoLibro")
	public String listarLibros(Model model) {
		model.addAttribute("listaLibros", libroRepo.findAll());
		return "listado-libros";
	}

	@GetMapping("/listadoSocio")
	public String listarSocios(Model model) {
		model.addAttribute("listaSocios", socioRepo.findAll());
		return "listado-socios";
	}

	@GetMapping("/altaLibro")
	public String mostrarFormLibro(Model model) {
		model.addAttribute("libro", new Libro());
		return "formulario-libro";
	}

	@PostMapping("/altaLibro")
	public String saveLibro(Libro libro) {
		libroRepo.save(libro);
		return "redirect:/listadoLibro";
	}

	@GetMapping("/altaSocio")
	public String mostrarAltaSocio(Model model) {
		model.addAttribute("socio", new Socio());
		return "formulario-socio";
	}

	@PostMapping("/altaSocio")
	public String saveSocio(Socio socio) {
		socioRepo.save(socio);
		return "redirect:/listadoSocio";
	}

}
