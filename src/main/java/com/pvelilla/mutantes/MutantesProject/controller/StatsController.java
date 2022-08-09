package com.pvelilla.mutantes.MutantesProject.controller;

import com.pvelilla.mutantes.MutantesProject.domain.StatDTO;
import com.pvelilla.mutantes.MutantesProject.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiv1/stats")
public class StatsController {

    private final StatService statService;

    @Autowired
    public StatsController(final StatService statService){
        this.statService = statService;
    }

    @CrossOrigin
    @GetMapping
    public StatDTO getStats() {
        return statService.getStats();
    }

}
