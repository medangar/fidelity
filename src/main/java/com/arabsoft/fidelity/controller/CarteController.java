package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.Carte;
import com.arabsoft.fidelity.request.DeleteRequest;
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

    @GetMapping("/client/{clientId}")
    public List<Carte> getCartesByClientId(@PathVariable(value = "clientId") Long clientId) {
        return carteService.getCarteByClientId(clientId);
    }



    @PostMapping
    private Carte saveClient(@RequestBody Carte carte) {
        System.out.println(carte);
        return carteService.saveOrUpdate(carte);
    }

    @PutMapping
    private Carte update(@RequestBody Carte carte) {
        return carteService.saveOrUpdate(carte);
    }

    @DeleteMapping("/{carteId}")
    public void deleteCarte(@PathVariable(value = "carteId") Long carteId) {
        carteService.delete(carteId);
    }

    @DeleteMapping
    public void deleteCartes(@RequestBody DeleteRequest userIds) {
        carteService.delete(userIds.getIds());
    }
}
