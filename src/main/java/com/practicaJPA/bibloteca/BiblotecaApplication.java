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
import java.time.LocalDate;
import java.util.Arrays;
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
	    // 10 libros de finanzas
	    libroRepo.saveAll(Arrays.asList(
	        new Libro(null, "El inversor inteligente", "Benjamin Graham", "978-8449342986", 1949),
	        new Libro(null, "Padre rico, padre pobre", "Robert Kiyosaki", "978-8466332132", 1997),
	        new Libro(null, "Un paso por delante de Wall Street", "Peter Lynch", "978-8491112051", 1989),
	        new Libro(null, "El pequeño libro que genera riqueza", "Pat Dorsey", "978-8478086698", 2008),
	        new Libro(null, "La bolsa o la vida", "Vicki Robin", "978-8416233050", 1992),
	        new Libro(null, "El hombre más rico de Babilonia", "George S. Clason", "978-8427027642", 1926),
	        new Libro(null, "Piense y hágase rico", "Napoleon Hill", "978-8427027642", 1937),
	        new Libro(null, "Los secretos de la mente millonaria", "T. Harv Eker", "978-8467031222", 2005),
	        new Libro(null, "El código del dinero", "Raimon Samsó", "978-8416463143", 2011),
	        new Libro(null, "Invertir en bolsa para principiantes", "Jorge Carrillo", "978-8417968003", 2020)
	    ));
	    
	    // 10 socios con temática financiera
	    socioRepo.saveAll(Arrays.asList(
	        new Socio(null, "Warren", "Buffett", "12345678A", LocalDate.of(2024, 1, 15)),
	        new Socio(null, "Charlie", "Munger", "23456789B", LocalDate.of(2024, 2, 20)),
	        new Socio(null, "Benjamin", "Graham", "34567890C", LocalDate.of(2024, 3, 10)),
	        new Socio(null, "Peter", "Lynch", "45678901D", LocalDate.of(2024, 4, 5)),
	        new Socio(null, "Robert", "Kiyosaki", "56789012E", LocalDate.of(2024, 5, 12)),
	        new Socio(null, "George", "Clason", "67890123F", LocalDate.of(2024, 6, 18)),
	        new Socio(null, "Napoleon", "Hill", "78901234G", LocalDate.of(2024, 7, 22)),
	        new Socio(null, "John", "Bogle", "89012345H", LocalDate.of(2024, 8, 30)),
	        new Socio(null, "Ray", "Dalio", "90123456I", LocalDate.of(2024, 9, 14)),
	        new Socio(null, "T. Harv", "Eker", "01234567J", LocalDate.of(2024, 10, 1))
	    ));
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
