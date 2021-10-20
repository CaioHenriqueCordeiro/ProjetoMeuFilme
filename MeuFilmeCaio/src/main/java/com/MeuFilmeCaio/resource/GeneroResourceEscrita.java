package com.MeuFilmeCaio.resource;

import com.MeuFilmeCaio.domain.Genero;
import com.MeuFilmeCaio.dto.SalvarGeneroDto;
import com.MeuFilmeCaio.service.GeneroService;

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
@RequestMapping("/genero")
public class GeneroResourceEscrita {

	GeneroService servico;

    @Autowired
    GeneroResourceEscrita(GeneroService servico) {
        this.servico = servico;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Genero> salvarGenero(@RequestBody SalvarGeneroDto genero){
    	return ResponseEntity.ok(servico.adicionarGenero(genero));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Genero> atualizarGenero(@PathVariable Long id, @RequestBody Genero genero){
    	return ResponseEntity.ok(servico.atualizarGeneroById(id, genero));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Genero> deleterDiretor(@PathVariable Long id){
    	return ResponseEntity.ok(servico.deletarGeneroById(id));
    }
}
