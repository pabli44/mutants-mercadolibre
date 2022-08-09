package com.pvelilla.mutantes.MutantesProject.service;

import com.pvelilla.mutantes.MutantesProject.domain.MutantDTO;

import java.util.List;

public interface MutantService {

    boolean save(MutantDTO mutantDTO);

    List<MutantDTO> findAll();

}
