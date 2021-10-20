package com.MeuFilmeCaio.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SalvarGeneroDto {
    @NotEmpty(message = "O nome do genero não pode ser vazio")
    String nome;
 
}
