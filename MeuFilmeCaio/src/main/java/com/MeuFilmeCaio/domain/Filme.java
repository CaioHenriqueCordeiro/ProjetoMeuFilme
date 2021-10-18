package com.MeuFilmeCaio.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Filme {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private int duracao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column
	private Date dataLancamento;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Genero genero;

	@OneToOne
	@JoinColumn(nullable = false)
	private Diretor diretor;
}
