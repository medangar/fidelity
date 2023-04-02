package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.Carte;

import java.util.List;

public interface CarteService {

    List<Carte> getAllCarte();

    Carte getCarteById(Long carteId);

    void delete(Long carteId);

    void saveOrUpdate(Carte carte);
}
