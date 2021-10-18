package com.MeuFilmeCaio.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.repository.FilmeRepository;

@RestController
@RequestMapping("/filmesGenero")
public class ListaFilmesPorGenero {
	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping
	public List<Filme> listaFilmesGenero(@RequestParam("nomeGenero") String nomeGenero){
		return filmeRepository.buscarFilmePorGenero(nomeGenero.toUpperCase());
		
	}
}
