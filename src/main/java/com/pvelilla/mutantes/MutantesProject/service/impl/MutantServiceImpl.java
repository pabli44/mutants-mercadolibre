package com.pvelilla.mutantes.MutantesProject.service.impl;

import com.pvelilla.mutantes.MutantesProject.config.dozer.DozerMappingBuilder;
import com.pvelilla.mutantes.MutantesProject.domain.MutantDTO;
import com.pvelilla.mutantes.MutantesProject.entities.Mutant;
import com.pvelilla.mutantes.MutantesProject.repository.MutantRepository;
import com.pvelilla.mutantes.MutantesProject.service.MutantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MutantServiceImpl implements MutantService {

    private static final Logger log = LoggerFactory.getLogger(MutantServiceImpl.class);
    private MutantRepository mutantRepository;


    public MutantServiceImpl(final MutantRepository mutantRepository){
        this.mutantRepository = mutantRepository;
    }

    @Override
    public boolean save(MutantDTO mutantDTO) {
        boolean val = isMutant(mutantDTO.getDna());
        Mutant mutant = new DozerMappingBuilder().map(mutantDTO, Mutant.class);
        mutant.setDna(Arrays.toString(mutantDTO.getDna()));
        mutant.setMutant(val?1:0);
        mutantRepository.save(mutant);

        log.info("Saving data: "+mutant);

        return val;
    }

    private boolean isMutant(String[] dna){
        List<List<String>> arrayConverted = getTwoDimensionsArray(dna);

        int results = 0;

        results+=getDiagonalSequences(arrayConverted);

        if(results<2){
            results+=getHorizontalSequences(arrayConverted);
        }else{
            results+=getVerticalSequences(arrayConverted);
        }

        return results<2?false:true;
    }

    private List<List<String>> getTwoDimensionsArray(String[] oneDimensionString){
        List<List<String>> resArray2 = new ArrayList<List<String>>();
        String v = "";

        for(int i=0;i<oneDimensionString.length;i++){
            resArray2.add(new ArrayList<String>());
            for(int c=0;c<oneDimensionString[i].length();c++){
                v = String.valueOf(oneDimensionString[i].charAt(c));
                resArray2.get(i).add(v);
            }
        }

        return resArray2;
    }

    private int getDiagonalSequences(List<List<String>> arrayConverted){
        int letterCounter = 1;
        int diagonalCounter = 0;

        for(int i=0;i<arrayConverted.size();i++){
            if(i>0){
                if(arrayConverted.get(i).get(i).equals(arrayConverted.get(i-1).get(i-1))){
                    letterCounter++;
                }else{
                    letterCounter = 1;
                }

                if(letterCounter==4){
                    diagonalCounter++;
                    letterCounter = 1;
                }
            }
        }

        return diagonalCounter;
    }

    private int getHorizontalSequences(List<List<String>> arrayConverted){
        int letterCounter = 1;
        int horizontalCounter = 0;

        for(int i=0;i<arrayConverted.size();i++){
            letterCounter = 1;
            for(int j=0;j<arrayConverted.get(i).size();j++){
                if(j>0){
                    if(arrayConverted.get(i).get(j).equals(arrayConverted.get(i).get(j-1))){
                        letterCounter++;
                    }else{
                        letterCounter = 1;
                    }

                    if(letterCounter==4){
                        horizontalCounter++;
                        letterCounter = 1;
                    }
                }
            }

        }

        return horizontalCounter;
    }

    private int getVerticalSequences(List<List<String>> arrayConverted){
        int letterCounter = 1;
        int verticalCounter = 0;
        int column = 0;

        for(int i=0;i<arrayConverted.size();i++){
            if(i>0){
                if(arrayConverted.get(i).get(column).equals(arrayConverted.get(i-1).get(column))){
                    letterCounter++;
                }else{
                    letterCounter = 1;
                }

                if(letterCounter==4){
                    verticalCounter++;
                    letterCounter = 1;
                }
            }

            if(i==arrayConverted.get(i).size()-1 && column==arrayConverted.get(i).size()-1){
                break;
            }

            if(i==arrayConverted.size()-1){
                column++;
                i = -1;
                letterCounter = 1;
            }
        }

        return verticalCounter;
    }

    @Override
    public List<MutantDTO> findAll() {
        return mutantRepository.findAll()
                                                   .stream()
                                                   .map(mapper -> new DozerMappingBuilder().convertToDTO(mapper, new MutantDTO()))
                                                    .collect(Collectors.toList());

    }
}
