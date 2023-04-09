package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.OffreAchat;
import com.arabsoft.fidelity.request.DeleteRequest;
import com.arabsoft.fidelity.service.OffreAchatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/offreAchat")
@RequiredArgsConstructor
@RestController
public class OffreAchatController {
    private final OffreAchatService offreAchatService;

    @GetMapping
    public List<OffreAchat> getAllOffres() {
        return offreAchatService.getAllOffreAchat();
    }

    @GetMapping("/{id}")
    public OffreAchat getOffreAchat(@PathVariable(value = "id") Long id) {
        return offreAchatService.getOffreAchatById(id);
    }

    @PostMapping
    private OffreAchat saveOffre(@RequestBody OffreAchat offreAchat) {
        //offreAchat.setValidite(LocalDate.now());
        System.err.println(offreAchat);
        return offreAchatService.save(offreAchat);
    }

    @PutMapping
    private OffreAchat update(@RequestBody OffreAchat offreAchat) {
        System.err.println(offreAchat);
        return offreAchatService.save(offreAchat);
    }

    @DeleteMapping("/{id}")
    public void deleteOffre(@PathVariable(value = "id") Long id) {
        offreAchatService.delete(id);
    }

    @DeleteMapping
    public void deleteOffres(@RequestBody DeleteRequest offreAchatIds) {
        offreAchatService.delete(offreAchatIds.getIds());
    }
}

