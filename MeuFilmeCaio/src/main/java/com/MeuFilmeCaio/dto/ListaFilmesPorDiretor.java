package com.MeuFilmeCaio.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.repository.FilmeRepository;

@RestController
@RequestMapping("/filmesDiretor")
public class ListaFilmesPorDiretor {
	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping("/{nome}")
	public List<Filme> listaFilmesGenero(@PathVariable String nome){
		return filmeRepository.buscarFilmePorDiretor(nome.toUpperCase());
		
	}
}
