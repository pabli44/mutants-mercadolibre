package com.pvelilla.mutantes.MutantesProject.repository;

import com.pvelilla.mutantes.MutantesProject.entities.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends JpaRepository<Mutant, Long>, JpaSpecificationExecutor<Mutant> {

}
