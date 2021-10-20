package com.MeuFilmeCaio.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MeuFilmeCaio.domain.Genero;
import com.MeuFilmeCaio.service.GeneroService;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroResourceLeitura {

    GeneroService servico;

    @Autowired
    GeneroResourceLeitura(GeneroService servico) {
        this.servico = servico;
    }

    @GetMapping
    public ResponseEntity<List<Genero>> getTodosGeneros() {
        return ResponseEntity.ok(servico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGeneroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servico.buscaGeneroById(id));
    }

}
