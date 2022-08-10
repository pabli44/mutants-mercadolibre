package com.pvelilla.mutantes.MutantesProject.service.impl;

import com.pvelilla.mutantes.MutantesProject.entities.Mutant;
import com.pvelilla.mutantes.MutantesProject.repository.MutantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MutantServiceImplTest {

    @InjectMocks
    private MutantServiceImpl mutantService;

    @Mock
    private MutantRepository mutantRepository;

    private Mutant mutant;
    private static final String DNA = "[ATGCGA, CGGTGC, TTATGT, AGAAGG, CTCCTA, TCACTG]";


    @BeforeEach
    public void setup(){
        mutantRepository = Mockito.mock(MutantRepository.class);
        mutantService = new MutantServiceImpl(mutantRepository);
        mutant = new Mutant();
    }

    @Test
    public void save() {
        mutant.setMutantId(1L);
        mutant.setDna(DNA);
        mutant.setMutant(1);

        when(mutantRepository.save(any(Mutant.class))).thenReturn(mutant);

    }

    @Test
    public void findAll() {
        when(mutantRepository.findAll()).thenReturn(Arrays.asList(new Mutant(), new Mutant()));

        assertThat(mutantService.findAll()).hasSize(2);
        verify(mutantRepository, times(1)).findAll();
        verifyNoMoreInteractions(mutantRepository);
    }
}