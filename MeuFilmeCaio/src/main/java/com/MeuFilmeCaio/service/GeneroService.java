package com.MeuFilmeCaio.service;

import com.MeuFilmeCaio.domain.Genero;
import com.MeuFilmeCaio.dto.SalvarGeneroDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GeneroService {
    //BUSCA TODOS OS GENEROS
	List<Genero> listar();
    
	// BUSCA GENERO PELO ID
    Genero buscaGeneroById(@PathVariable Long id);
    
    // SALVA GENERO NO BD
    Genero adicionarGenero(@RequestBody SalvarGeneroDto genero);
    
    // ATUALIZA GENERO NO BD PELO ID
    Genero atualizarGeneroById(@PathVariable Long id, @RequestBody Genero genero);
    
    // DELETA GENERO NO BD PELO ID
    Genero deletarGeneroById(@PathVariable Long id);
}
