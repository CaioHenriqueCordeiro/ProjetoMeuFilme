package com.MeuFilmeCaio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Genero;
import com.MeuFilmeCaio.dto.SalvarGeneroDto;
import com.MeuFilmeCaio.repository.GeneroRepository;

@Service
@RestController
public class GeneroService implements com.MeuFilmeCaio.service.GeneroService{
	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> listar() {
		return generoRepository.findAll();
	}

	public Genero buscaGeneroById(@PathVariable Long id) {
		return generoRepository.findById(id).get();
	}
	
	public Genero adicionarGenero(@RequestBody SalvarGeneroDto genero) {
		Genero generoDomain = new Genero();
		
		generoDomain.setNome(genero.getNome());
		
		return generoRepository.save(generoDomain);
	}
	
	public Genero atualizarGeneroById(@PathVariable Long id, @RequestBody Genero genero) {
		Genero gen = generoRepository.findById(id).get();	
		gen.setNome(genero.getNome());
		
		System.out.println(gen.getId());
		System.out.println(gen.getNome());
		
		return generoRepository.save(gen);
	}
	
	public Genero deletarGeneroById(@PathVariable Long id) {
		Genero genDeletado = generoRepository.findById(id).get();
		generoRepository.deleteById(id);
		
		return genDeletado;
	}
}
