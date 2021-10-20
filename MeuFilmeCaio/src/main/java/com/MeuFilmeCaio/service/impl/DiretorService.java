package com.MeuFilmeCaio.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Diretor;
import com.MeuFilmeCaio.dto.SalvarDiretorDto;
import com.MeuFilmeCaio.repository.DiretorRepository;

@Service
@RestController
public class DiretorService implements com.MeuFilmeCaio.service.DiretorService{
	@Autowired
	private DiretorRepository diretorRepository;
	
	public List<Diretor> listar() {
		return diretorRepository.findAll();
	}
	
	public Diretor buscaDiretorById(@PathVariable Long id) {
		return diretorRepository.findById(id).get();
	}

	public Diretor adicionarDiretor(@RequestBody @Valid SalvarDiretorDto diretor) {
		Diretor diretorDomain = new Diretor();
		
		diretorDomain.setNome(diretor.getNome());
		diretorDomain.setDataNascimento(diretor.getDataNascimento());
		
		return diretorRepository.save(diretorDomain);
	}
	
	public Diretor atualizarDiretorById(@PathVariable Long id, @RequestBody @Valid Diretor diretor) {
		Diretor diretorAtt = diretorRepository.findById(id).get();
		
		diretorAtt.setNome(diretor.getNome());
		diretorAtt.setDataNascimento(diretor.getDataNascimento());
		
		return diretorRepository.save(diretorAtt);
	}
	
	public Diretor deletarDiretorById(@PathVariable Long id) {
		Diretor dirDeletado = diretorRepository.findById(id).get();
		diretorRepository.deleteById(id);
		
		return dirDeletado;
	}
}
