package com.MeuFilmeCaio;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.MeuFilmeCaio.domain.Genero;
import com.MeuFilmeCaio.dto.SalvarGeneroDto;
import com.MeuFilmeCaio.repository.GeneroRepository;
import com.MeuFilmeCaio.service.impl.GeneroService;

@RunWith(MockitoJUnitRunner.class)
public class MeuFilmeTestGenero{
	
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    
    @InjectMocks 
    GeneroService generoService;
    
	@Mock
	private GeneroRepository generoRepository;
    
	@Test
	@DisplayName("Testa inclusão de genero")
	public void adicionarGenero() {
		Genero g = new Genero();
		g.setNome("Terror");
		Mockito.when(generoRepository.save(Mockito.any())).thenReturn(g);
		
		SalvarGeneroDto gen = new SalvarGeneroDto();
		gen.setNome("Terror");
		Genero resp = generoService.adicionarGenero(gen);
		
		assertTrue(resp.getNome().equals(gen.getNome()));
	}
}
