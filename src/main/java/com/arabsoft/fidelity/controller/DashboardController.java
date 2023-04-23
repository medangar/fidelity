package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.response.DashboardClientResponse;
import com.arabsoft.fidelity.response.DashboardResponse;
import com.arabsoft.fidelity.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public DashboardResponse getData(){
        return dashboardService.getData();
    }
    @GetMapping("/{identifiant}")
    public DashboardClientResponse getDataForClient(@PathVariable(value = "identifiant") String identifiant){
        return dashboardService.getDataForClient(identifiant);
    }
}