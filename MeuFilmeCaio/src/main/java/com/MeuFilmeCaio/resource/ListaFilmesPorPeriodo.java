package com.MeuFilmeCaio.resource;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.repository.FilmeRepository;

@RestController
@RequestMapping("/filmesPeriodo")
public class ListaFilmesPorPeriodo {
	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping
	public List<Filme> listaFilmesPeriodo(@RequestParam String inicio, @RequestParam String fim) throws ParseException{
		LocalDate dataini = LocalDate.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate datafim = LocalDate.parse(fim, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
	
		
		return filmeRepository.buscarFilmePorPeriodo(dataini, datafim);
	}
}
