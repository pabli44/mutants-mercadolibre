package com.pvelilla.mutantes.MutantesProject.controller;


import com.pvelilla.mutantes.MutantesProject.domain.MutantDTO;
import com.pvelilla.mutantes.MutantesProject.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/apiv1/mutant")
public class MutantController {

    private final MutantService mutantService;

    @Autowired
    public MutantController(final MutantService mutantService) {
        this.mutantService = mutantService;
    }

    @PostMapping
    public HttpEntity<Boolean> save(@RequestBody @Valid MutantDTO mutantDTO) {
        Boolean res = mutantService.save(mutantDTO);

        if(res.equals(null)){
            return new ResponseEntity<Boolean>(res, HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<Boolean>(res, HttpStatus.OK);
    }


}
