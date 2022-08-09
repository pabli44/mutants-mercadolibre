package com.pvelilla.mutantes.MutantesProject.service.impl;

import com.pvelilla.mutantes.MutantesProject.domain.MutantDTO;
import com.pvelilla.mutantes.MutantesProject.domain.StatDTO;
import com.pvelilla.mutantes.MutantesProject.service.MutantService;
import com.pvelilla.mutantes.MutantesProject.service.StatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatServiceImpl implements StatService {

    private static final Logger log = LoggerFactory.getLogger(StatServiceImpl.class);

    private final MutantService mutantService;

    public StatServiceImpl(final MutantService mutantService){
        this.mutantService = mutantService;
    }
    @Override
    public StatDTO getStats() {
        List<MutantDTO> getAllMutants = mutantService.findAll();
        long mutant_dna_count = getAllMutants.stream().filter(mut -> mut.getMutant()==1).collect(Collectors.counting());
        long human_dna_count = getAllMutants.stream().filter(mut -> mut.getMutant()==0).collect(Collectors.counting());
        double ratio = (float)mutant_dna_count / human_dna_count;
        log.info(String.format("Getting stats: Mutants: %s- Humans: %s- Ratio: %s", mutant_dna_count, human_dna_count, ratio));

        return new StatDTO(mutant_dna_count, human_dna_count, ratio);
    }
}
