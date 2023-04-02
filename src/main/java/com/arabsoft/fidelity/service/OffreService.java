package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.Offre;

import java.util.List;

public interface OffreService {
    List<Offre> getAllOffre();

    Offre getOffreById(Long id);

    void delete(Long id);

    Offre save(Offre offre);

    void delete(List<Long> ids);
}
