package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.Offre;
import com.arabsoft.fidelity.model.OffreProduit;
import com.arabsoft.fidelity.request.DeleteRequest;
import com.arabsoft.fidelity.service.OffreProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/offreProduit")
@RequiredArgsConstructor
@RestController
public class OffreProduitController {
    private final OffreProduitService offreProduitService;
    @GetMapping
    public List<OffreProduit> getAllOffres() {
        return offreProduitService.getAllOffreProduit();
    }

    @GetMapping("/{id}")
    public OffreProduit getOffre(@PathVariable(value = "id") Long id) {
        return offreProduitService.getOffreProduitById(id);
    }

    @PostMapping
    private OffreProduit saveOffre(@RequestBody OffreProduit offreProduit) {
        //offreProduit.setValidite(LocalDate.now());
        System.err.println(offreProduit);
        return offreProduitService.save(offreProduit);
    }


    @PutMapping
    private OffreProduit update(@RequestBody OffreProduit offreProduit) {
        System.err.println(offreProduit);
        return offreProduitService.save(offreProduit);
    }

    @DeleteMapping("/{id}")
    public void deleteOffre(@PathVariable(value = "id") Long id) {
        offreProduitService.delete(id);
    }

    @DeleteMapping
    public void deleteOffres(@RequestBody DeleteRequest offreProduitIds) {
        offreProduitService.delete(offreProduitIds.getIds());
    }
}
