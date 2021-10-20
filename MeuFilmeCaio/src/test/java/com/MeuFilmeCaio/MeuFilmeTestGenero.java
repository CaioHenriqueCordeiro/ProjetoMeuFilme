package com.MeuFilmeCaio;

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
		SalvarGeneroDto gen = new SalvarGeneroDto();
		
		gen.setNome("Terror");
		
		Genero genDomain = new Genero();
		genDomain.setNome(gen.getNome());
		
		generoService.adicionarGenero(gen);
		verify(generoRepository, Mockito.times(1)).save(genDomain);
	}
}
