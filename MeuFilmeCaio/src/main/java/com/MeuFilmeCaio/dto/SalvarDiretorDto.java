package com.MeuFilmeCaio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class SalvarDiretorDto {
    @NotEmpty(message = "O nome não pode ser vazio")
    String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data de nascimento é obrigatoria")
    LocalDate dataNascimento;
}
