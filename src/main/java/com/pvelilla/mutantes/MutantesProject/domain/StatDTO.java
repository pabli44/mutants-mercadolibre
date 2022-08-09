package com.pvelilla.mutantes.MutantesProject.domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatDTO {

    private long count_mutant_dna;
    private long count_human_dna;
    private double ratio;
}
