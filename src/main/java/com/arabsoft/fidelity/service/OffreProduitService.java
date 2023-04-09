package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.OffreProduit;

import java.util.List;

public interface OffreProduitService {
    List<OffreProduit> getAllOffreProduit();

    OffreProduit getOffreProduitById(Long id);

    void delete(Long id);

    OffreProduit save(OffreProduit offreProduit);

    void delete(List<Long> ids);
}
