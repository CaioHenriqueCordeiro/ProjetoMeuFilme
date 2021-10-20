package com.MeuFilmeCaio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.dto.SalvarFilmeDto;
import com.MeuFilmeCaio.repository.FilmeRepository;

@Service
@RestController
public class FilmeService implements com.MeuFilmeCaio.service.FilmeService{
	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<Filme> listar() {
		return filmeRepository.findAll();
	}
	
	public Filme buscaFilmeById(@PathVariable Long id) {
		return filmeRepository.findById(id).get();
	}

	public Filme adicionarFilme(@RequestBody SalvarFilmeDto filme) {
		Filme filmeDomain = new Filme();
		
		filmeDomain.setNome(filme.getNome());
		filmeDomain.setDataLancamento(filme.getDataLancamento());
		filmeDomain.setDuracao(filme.getDuracao());
		filmeDomain.setDiretor(filme.getDiretor());
		filmeDomain.setGenero(filme.getGenero());
		
		return filmeRepository.save(filmeDomain);
	}

	public Filme atualizarFilmeById(@PathVariable Long id, @RequestBody Filme filme) {
		Filme filmeDomain = filmeRepository.findById(id).get();	
		
		filmeDomain.setNome(filme.getNome());
		filmeDomain.setDuracao(filme.getDuracao());
		filmeDomain.setDiretor(filme.getDiretor());
		filmeDomain.setGenero(filme.getGenero());
		filmeDomain.setDataLancamento(filme.getDataLancamento());
		
		return filmeRepository.save(filmeDomain);
	}

	public Filme deletarFilmeById(@PathVariable Long id) {
		Filme filDeletado = filmeRepository.findById(id).get();
		filmeRepository.deleteById(id);
		
		return filDeletado;
	}	
}
