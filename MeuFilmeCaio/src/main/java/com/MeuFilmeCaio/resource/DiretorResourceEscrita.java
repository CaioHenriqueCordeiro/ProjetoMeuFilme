package com.MeuFilmeCaio.resource;


import com.MeuFilmeCaio.domain.Diretor;
import com.MeuFilmeCaio.dto.SalvarDiretorDto;
import com.MeuFilmeCaio.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diretor")
public class DiretorResourceEscrita {

	DiretorService servico;

    @Autowired
    DiretorResourceEscrita(DiretorService servico) {
        this.servico = servico;
    }

    @PostMapping
    public ResponseEntity<Diretor> salvarDiretor(@RequestBody SalvarDiretorDto diretor){
    	return ResponseEntity.ok(servico.adicionarDiretor(diretor));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Diretor> atualizarDiretor(@PathVariable Long id, @RequestBody Diretor diretor){
    	return ResponseEntity.ok(servico.atualizarDiretorById(id, diretor));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Diretor> deleterDiretor(@PathVariable Long id){
    	return ResponseEntity.ok(servico.deletarDiretorById(id));
    }
}
