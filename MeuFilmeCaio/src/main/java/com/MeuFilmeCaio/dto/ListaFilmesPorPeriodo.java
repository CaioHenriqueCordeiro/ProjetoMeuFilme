package com.MeuFilmeCaio.dto;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.repository.FilmeRepository;

@RestController
@RequestMapping("/filmesPeriodo")
public class ListaFilmesPorPeriodo {
	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping("/{inicio}/{fim}")
	public List<Filme> listaFilmesPeriodo(@PathVariable String inicio, @PathVariable String fim) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date dataini = formatter.parse(inicio);
		Date datafim = formatter.parse(fim);
		
		return filmeRepository.buscarFilmePorPeriodo(dataini, datafim);
	}
}
