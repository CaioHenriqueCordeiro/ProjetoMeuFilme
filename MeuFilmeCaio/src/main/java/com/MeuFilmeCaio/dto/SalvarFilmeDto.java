package com.MeuFilmeCaio.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.MeuFilmeCaio.domain.Diretor;
import com.MeuFilmeCaio.domain.Genero;

@Getter
@Setter
public class SalvarFilmeDto {
    @NotEmpty(message = "O nome do filme não pode ser vazio")
    String nome;
 
    @NotEmpty(message = "Data de lançamento não pode ser vazia")
    LocalDate dataLancamento;
    
    @NotEmpty(message = "Duração do filme não pode ser vazia")
    int duracao;
    
    @NotEmpty(message = "Genero não pode estar vazio")
    Genero geneno;
    
    @NotEmpty(message = "Diretor não pode estar vazio")
    Diretor diretor;
    
}
