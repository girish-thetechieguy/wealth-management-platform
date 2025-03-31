package com.jpmorgan.wm.jpm_advisory_service.controller;

import com.jpmorgan.wm.jpm_advisory_service.model.Advisor;
import com.jpmorgan.wm.jpm_advisory_service.model.AdvisorStatus;
import com.jpmorgan.wm.jpm_advisory_service.service.AdvisorService;
import com.netflix.graphql.dgs.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class AdvisorController {
    private final AdvisorService advisorService;

    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    @DgsQuery
    public List<Advisor> advisors() {
        return advisorService.getAllAdvisors();
    }

    @DgsQuery
    public Advisor advisor(@InputArgument Long id) {
        return advisorService.getAdvisorById(id);
    }

    @DgsQuery
    public List<Advisor> advisorsByStatus(@InputArgument AdvisorStatus status) {
        return advisorService.getAdvisorsByStatus(status);
    }

    @DgsMutation
    public Advisor createAdvisor(@InputArgument("input") Advisor input) {
        return advisorService.createAdvisor(input);
    }

    @DgsMutation
    public Advisor updateAdvisor(
            @InputArgument Long id,
            @InputArgument("input") Advisor input) {
        return advisorService.updateAdvisor(id, input);
    }

    @DgsMutation
    public Boolean deleteAdvisor(@InputArgument Long id) {
        return advisorService.deleteAdvisor(id);
    }
}