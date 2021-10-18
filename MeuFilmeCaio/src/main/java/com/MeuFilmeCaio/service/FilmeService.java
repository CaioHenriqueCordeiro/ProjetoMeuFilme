package com.MeuFilmeCaio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.repository.FilmeRepository;

@RestController
@RequestMapping
public class FilmeService {
	@Autowired
	private FilmeRepository filmeRepository;
	
	@GetMapping
	public List<Filme> listar() {
		return filmeRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Filme adicionar(@RequestBody Filme filme) {
		return filmeRepository.save(filme);
	}
}
