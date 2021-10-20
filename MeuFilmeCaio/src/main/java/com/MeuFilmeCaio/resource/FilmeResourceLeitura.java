package com.MeuFilmeCaio.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Filme;
import com.MeuFilmeCaio.service.FilmeService;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeResourceLeitura {

	FilmeService servico;

    @Autowired
    FilmeResourceLeitura(FilmeService servico) {
        this.servico = servico;
    }

    @GetMapping
    public ResponseEntity<List<Filme>> getTodosFilmes() {
        return ResponseEntity.ok(servico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmePorId(@PathVariable Long id) {
        return ResponseEntity.ok(servico.buscaFilmeById(id));
    }

}
