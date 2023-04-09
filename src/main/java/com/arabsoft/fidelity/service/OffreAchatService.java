package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.OffreAchat;

import java.util.List;

public interface OffreAchatService {
    List<OffreAchat> getAllOffreAchat();

    OffreAchat getOffreAchatById(Long id);

    void delete(Long id);

    OffreAchat save(OffreAchat offreAchat);

    void delete(List<Long> ids);
}
