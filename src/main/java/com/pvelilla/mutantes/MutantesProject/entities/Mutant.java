package com.pvelilla.mutantes.MutantesProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mutants")
@Setter
@Getter
@NoArgsConstructor
public class Mutant {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mutantId;

    @Column(name = "dna")
    private String dna;

    @Column(name = "mutant")
    private int mutant;


}

