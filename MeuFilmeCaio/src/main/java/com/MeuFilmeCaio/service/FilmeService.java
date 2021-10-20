package com.MeuFilmeCaio.service;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.dto.SalvarFilmeDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface FilmeService {
    //BUSCA TODOS OS FILMES
	List<Filme> listar();
    
	// BUSCA FILME PELO ID
    Filme buscaFilmeById(@PathVariable Long id);
    
    // SALVA FILME NO BD
    Filme adicionarFilme(@RequestBody SalvarFilmeDto filme);
    
    // ATUALIZA FILME NO BD PELO ID
    Filme atualizarFilmeById(@PathVariable Long id, @RequestBody Filme filme);
    
    // DELETA FILME NO BD PELO ID
    Filme deletarFilmeById(@PathVariable Long id);
}
