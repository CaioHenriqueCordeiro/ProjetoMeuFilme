package com.MeuFilmeCaio.service;

import com.MeuFilmeCaio.domain.Diretor;
import com.MeuFilmeCaio.dto.SalvarDiretorDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DiretorService {
    //BUSCA TODOS OS DIRETORES
	List<Diretor> listar();
    
	// BUSCA DIRETOR PELO ID
    Diretor buscaDiretorById(@PathVariable Long id);
    
    // SALVA DIRETOR NO BD
    Diretor adicionarDiretor(@RequestBody SalvarDiretorDto diretor);
    
    // ATUALIZA DIRETOR NO BD PELO ID
    Diretor atualizarDiretorById(@PathVariable Long id, @RequestBody Diretor diretor);
    
    // DELETA DIRETOR NO BD PELO ID
    Diretor deletarDiretorById(@PathVariable Long id);
}
