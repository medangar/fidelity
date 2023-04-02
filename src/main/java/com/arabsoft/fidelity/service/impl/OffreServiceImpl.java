package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.model.Offre;
import com.arabsoft.fidelity.repository.OffreRepository;
import com.arabsoft.fidelity.service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreServiceImpl implements OffreService {
    private final OffreRepository offreRepository;

    @Override
    public List<Offre> getAllOffre() {
        return offreRepository.findAll();
    }

    @Override
    public Offre getOffreById(Long id) {
        return offreRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        offreRepository.deleteById(id);
    }

    @Override
    public Offre save(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(offreRepository::deleteById);
    }
}
