package com.MeuFilmeCaio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MeuFilmeCaio.domain.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	@Query(
			value = "Select f from Filme f inner join f.genero g Where Upper(g.nome) = ?1"
		)
	List<Filme> buscarFilmePorGenero(String nomeGenero);
}
