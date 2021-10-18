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

import com.MeuFilmeCaio.domain.Genero;
import com.MeuFilmeCaio.repository.GeneroRepository;

@RestController
@RequestMapping("/genero")
public class GeneroService {
	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping
	public List<Genero> listar() {
		return generoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Genero buscaGeneroById(@PathVariable Long id) {
		return generoRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Genero adicionar(@RequestBody Genero genero) {
		return generoRepository.save(genero);
	}
	
	@PutMapping("/{id}")
	public Genero atualizar(@PathVariable Long id, @RequestBody Genero genero) {
		Genero gen = generoRepository.findById(id).get();	
		gen.setNome(genero.getNome());
		
		System.out.println(gen.getId());
		System.out.println(gen.getNome());
		
		return generoRepository.save(gen);
	}
	
	@DeleteMapping("/{id}")
	public Genero deletar(@PathVariable Long id) {
		Genero genDeletado = generoRepository.findById(id).get();
		generoRepository.deleteById(id);
		
		return genDeletado;
	}
	
}
