package com.pvelilla.mutantes.MutantesProject.controller;

import com.pvelilla.mutantes.MutantesProject.domain.MutantDTO;
import com.pvelilla.mutantes.MutantesProject.repository.MutantRepository;
import com.pvelilla.mutantes.MutantesProject.service.impl.MutantServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MutantControllerTest {

    @Mock
    private MutantRepository mutantRepository;

    @InjectMocks
    private MutantServiceImpl mutantService;

    private MutantDTO mutantDTO;

    private static final String[] DNA = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

    public MutantControllerTest() {
    }

    @BeforeEach
    public void setup(){
        mutantRepository = Mockito.mock(MutantRepository.class);
        mutantService = new MutantServiceImpl(mutantRepository);
        mutantDTO = new MutantDTO();
    }

    @Test
    public void save() {
        mutantDTO.setMutantId(1L);
        mutantDTO.setDna(DNA);
        mutantDTO.setMutant(1);

        mutantService.save(mutantDTO);
        assertNotNull(mutantDTO.getMutantId());

    }
}