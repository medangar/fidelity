package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.Offre;
import com.arabsoft.fidelity.request.DeleteRequest;
import com.arabsoft.fidelity.service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/offre")
@RequiredArgsConstructor
@RestController
public class OffreController {
    private final OffreService offreService;

    @GetMapping
    public List<Offre> getAllOffres() {
        return offreService.getAllOffre();
    }

    @GetMapping("/{id}")
    public Offre getOffre(@PathVariable(value = "id") Long id) {
        return offreService.getOffreById(id);
    }

    @PostMapping
    private Offre saveOffre(@RequestBody Offre offre) {
        offre.setValidite(LocalDate.now());
        System.err.println(offre);
        return offreService.save(offre);
    }

    @PutMapping
    private Offre update(@RequestBody Offre offre) {
        System.err.println(offre);
        return offreService.save(offre);
    }

    @DeleteMapping("/{id}")
    public void deleteOffre(@PathVariable(value = "id") Long id) {
        offreService.delete(id);
    }

    @DeleteMapping
    public void deleteOffres(@RequestBody DeleteRequest offreIds) {
        offreService.delete(offreIds.getIds());
    }
}
