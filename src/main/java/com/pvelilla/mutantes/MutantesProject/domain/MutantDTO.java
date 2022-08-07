package com.pvelilla.mutantes.MutantesProject.domain;

import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MutantDTO {

    private Long mutantId;

    @NotNull
    private String[] dna;
}
