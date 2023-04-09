package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.model.OffreProduit;
import com.arabsoft.fidelity.repository.OffreProduitRepository;
import com.arabsoft.fidelity.service.OffreProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreProduitServiceImpl implements OffreProduitService {
    private final OffreProduitRepository offreProduitRepository;

    @Override
    public List<OffreProduit> getAllOffreProduit() {
        return offreProduitRepository.findAll();
    }

    @Override
    public OffreProduit getOffreProduitById(Long id) {
        return offreProduitRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        offreProduitRepository.deleteById(id);
    }

    @Override
    public OffreProduit save(OffreProduit offreProduit) {
        return offreProduitRepository.save(offreProduit);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(offreProduitRepository::deleteById);
    }
}
