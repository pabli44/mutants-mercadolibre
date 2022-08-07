package com.pvelilla.mutantes.MutantesProject.service.impl;

import com.pvelilla.mutantes.MutantesProject.config.dozer.DozerMappingBuilder;
import com.pvelilla.mutantes.MutantesProject.domain.MutantDTO;
import com.pvelilla.mutantes.MutantesProject.entities.Mutant;
import com.pvelilla.mutantes.MutantesProject.repository.MutantRepository;
import com.pvelilla.mutantes.MutantesProject.service.MutantService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;

@Service
public class MutantServiceImpl implements MutantService {

    private MutantRepository mutantRepository;


    public MutantServiceImpl(final MutantRepository mutantRepository){
        this.mutantRepository = mutantRepository;
    }

    @Override
    public boolean save(MutantDTO mutantDTO) {
        Mutant mutant = new DozerMappingBuilder().map(mutantDTO, Mutant.class);
        mutant.setDna(Arrays.toString(mutantDTO.getDna()));
        mutantRepository.save(mutant);

        return isMutant(mutantDTO.getDna());
    }

    private boolean isMutant(String[] dna){

        String[][] arrayConverted = getTwoDimensionsArray(dna);

        int diagonalCounter = getDiagonalSequences(arrayConverted);
        int horizontalCounter = getHorizontalSequences(arrayConverted);
        int verticalCounter = getVerticalSequences(arrayConverted);

        for(int i=0;i<arrayConverted.length;i++){
            for(int j=0;j<arrayConverted[i].length;j++){
                System.out.println(i+","+j+"= "+arrayConverted[i][j]);
            }
        }

        return false;
    }

    private String[][] getTwoDimensionsArray(String[] oneDimensionString){
        String[][] resArray = new String[6][6];
        LinkedList<String> resArray2 = new LinkedList<>();

        for(int i=0;i<oneDimensionString.length;i++){
            for(int c=0;c<oneDimensionString[i].length();c++){
                resArray[i][c] = String.valueOf(oneDimensionString[i].charAt(c));

                //resArray2.add(i, resArray[i][c]);

                System.out.println(i+","+c+": "+resArray[i][c]);
            }
        }

        //System.out.println("resArray2: "+resArray2);

        return resArray;
    }

    private int getDiagonalSequences(String[][] arrayConverted){
        int letterCounter = 1;
        int diagonalCounter = 0;

        for(int i=0;i<arrayConverted.length;i++){
            if(i>0){
                if(arrayConverted[i][i].equals(arrayConverted[i-1][i-1])){
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

    private int getHorizontalSequences(String[][] arrayConverted){
        int letterCounter = 1;
        int horizontalCounter = 0;

        for(int i=0;i<arrayConverted.length;i++){
            letterCounter = 1;
            for(int j=0;j<arrayConverted[i].length;j++){
                if(j>0){
                    if(arrayConverted[i][j].equals(arrayConverted[i][j-1])){
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

    private int getVerticalSequences(String[][] arrayConverted){
        int letterCounter = 1;
        int verticalCounter = 0;
        int column = 0;

        for(int i=0;i<arrayConverted.length;i++){
            if(i>0){
                if(arrayConverted[i][column].equals(arrayConverted[i-1][column])){
                    letterCounter++;
                }else{
                    letterCounter = 1;
                }

                if(letterCounter==4){
                    verticalCounter++;
                    letterCounter = 1;
                }
            }

            if(i==arrayConverted[i].length-1 && column==arrayConverted[i].length-1){
                break;
            }

            if(i==arrayConverted.length-1){
                column++;
                i = -1;
                letterCounter = 1;
            }
        }

        return verticalCounter;
    }
}
