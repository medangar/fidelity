package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.model.Carte;
import com.arabsoft.fidelity.repository.CarteRepository;
import com.arabsoft.fidelity.service.CarteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarteServiceImpl implements CarteService {

    private final CarteRepository carteRepository;

    public List<Carte> getAllCarte() {
        return carteRepository.findAll();
    }

    public Carte getCarteById(Long carteId) {
        return carteRepository.findById((long) carteId).get();
    }

    public Carte saveOrUpdate(Carte carte) {
        return carteRepository.save(carte);
    }

    public void delete(Long carteId) {
        carteRepository.deleteById((long) carteId);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(carteRepository::deleteById);
    }
}
