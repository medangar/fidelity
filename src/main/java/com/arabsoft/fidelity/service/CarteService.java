package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.Carte;

import java.util.List;

public interface CarteService {

    List<Carte> getAllCarte();

    Carte getCarteById(Long carteId);

    void delete(Long carteId);

    Carte saveOrUpdate(Carte carte);

    void delete(List<Long> ids);
}
