package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.Carte;
import com.arabsoft.fidelity.service.CarteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carte")
@RequiredArgsConstructor
public class CarteController {

    private final CarteService carteService;

    @GetMapping
    public List<Carte> getAllCartes() {
        return carteService.getAllCarte();
    }

    @GetMapping("/{carteId}")
    public Carte getCarte(@PathVariable(value = "carteId") Long carteId) {
        return carteService.getCarteById(carteId);
    }

    @DeleteMapping("/{carteId}")
    public void deleteCarte(@PathVariable(value = "carteId") Long carteId) {
        carteService.delete(carteId);
    }

    @PostMapping
    private int saveClient(@RequestBody Carte carte) {
        carteService.saveOrUpdate(carte);
        return Math.toIntExact(carte.getCarteId());
    }

    @PutMapping
    private Carte update(@RequestBody Carte carte) {
        carteService.saveOrUpdate(carte);
        return carte;
    }
}
