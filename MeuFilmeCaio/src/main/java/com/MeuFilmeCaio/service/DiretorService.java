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

import com.MeuFilmeCaio.domain.Diretor;
import com.MeuFilmeCaio.repository.DiretorRepository;

@RestController
@RequestMapping("/diretor")
public class DiretorService {
	@Autowired
	private DiretorRepository diretorRepository;
	
	@GetMapping
	public List<Diretor> listar() {
		return diretorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Diretor buscaDiretorById(@PathVariable Long id) {
		return diretorRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Diretor adicionar(@RequestBody Diretor diretor) {
		return diretorRepository.save(diretor);
	}
	
	@PutMapping("/{id}")
	public Diretor atualizar(@PathVariable Long id, @RequestBody Diretor diretor) {
		Diretor dir = diretorRepository.findById(id).get();	
		dir.setNome(diretor.getNome());
		
		return diretorRepository.save(dir);
	}
	
	@DeleteMapping("/{id}")
	public Diretor deletar(@PathVariable Long id) {
		Diretor dirDeletado = diretorRepository.findById(id).get();
		diretorRepository.deleteById(id);
		
		return dirDeletado;
	}
}
