package com.MeuFilmeCaio.resource;


import com.MeuFilmeCaio.domain.Diretor;
import com.MeuFilmeCaio.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diretor")
public class DiretorResourceLeitura {

    DiretorService servico;

    @Autowired
    DiretorResourceLeitura(DiretorService servico) {
        this.servico = servico;
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> getTodosDiretores() {
        return ResponseEntity.ok(servico.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDiretorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servico.buscaDiretorById(id));
    }

}
