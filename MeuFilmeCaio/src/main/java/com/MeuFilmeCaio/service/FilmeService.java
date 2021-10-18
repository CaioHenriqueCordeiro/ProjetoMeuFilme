package com.MeuFilmeCaio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.repository.FilmeRepository;

@RestController
@RequestMapping("/filme")
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

	@PutMapping("/{id}")
	public Filme atualizar(@PathVariable Long id, @RequestBody Filme filme) {
		Filme fil = filmeRepository.findById(id).get();	
		
		fil.setNome(filme.getNome());
		fil.setDuracao(filme.getDuracao());
		fil.setDiretor(filme.getDiretor());
		fil.setGenero(filme.getGenero());
		fil.setDataLancamento(filme.getDataLancamento());
		
		return filmeRepository.save(fil);
	}
	
	@DeleteMapping("/{id}")
	public Filme deletar(@PathVariable Long id) {
		Filme filDeletado = filmeRepository.findById(id).get();
		filmeRepository.deleteById(id);
		
		return filDeletado;
	}
}
