package com.MeuFilmeCaio.resource;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.dto.SalvarFilmeDto;
import com.MeuFilmeCaio.service.FilmeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
public class FilmeResourceEscrita {

	FilmeService servico;

    @Autowired
    FilmeResourceEscrita(FilmeService servico) {
        this.servico = servico;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Filme> salvarFilme(@RequestBody SalvarFilmeDto filme){
    	return ResponseEntity.ok(servico.adicionarFilme(filme));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filme){
    	return ResponseEntity.ok(servico.atualizarFilmeById(id, filme));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> deletarFilme(@PathVariable Long id){
    	return ResponseEntity.ok(servico.deletarFilmeById(id));
    }
}
