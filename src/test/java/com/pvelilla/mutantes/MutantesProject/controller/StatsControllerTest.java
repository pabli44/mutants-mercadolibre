package com.pvelilla.mutantes.MutantesProject.controller;

import com.pvelilla.mutantes.MutantesProject.domain.StatDTO;
import com.pvelilla.mutantes.MutantesProject.service.MutantService;
import com.pvelilla.mutantes.MutantesProject.service.impl.StatServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatsControllerTest {

    @Mock
    private MutantService mutantService;

    @InjectMocks
    private StatServiceImpl statService;

    private StatDTO statDTO;

    public StatsControllerTest() {
    }

    @BeforeEach
    public void setup(){
        mutantService = Mockito.mock(MutantService.class);
        statService = new StatServiceImpl(mutantService);
        statDTO = new StatDTO();
    }

    @Test
    public void getStats() {
        statService.getStats();
        assertNotNull(statDTO.getRatio());

    }
}