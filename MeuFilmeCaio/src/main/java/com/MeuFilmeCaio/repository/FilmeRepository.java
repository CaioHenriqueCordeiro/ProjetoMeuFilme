package com.MeuFilmeCaio.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MeuFilmeCaio.domain.Filme;
public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	@Query(
			value = "Select f from Filme f inner join f.genero g Where Upper(g.nome) = :g"
		)
	List<Filme> buscarFilmePorGenero(@Param("g") String nome);
	
	@Query(
			value = "Select f from Filme f inner join f.diretor d Where Upper(d.nome) = :d"
		)
	List<Filme> buscarFilmePorDiretor(@Param("d") String nome);
	
	@Query(
			value = "Select f from Filme f where f.dataLancamento BETWEEN :inicio and :fim"
		)
	List<Filme> buscarFilmePorPeriodo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
	
}
