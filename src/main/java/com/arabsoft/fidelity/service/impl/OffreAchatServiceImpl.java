package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.model.OffreAchat;
import com.arabsoft.fidelity.repository.OffreAchatRepository;
import com.arabsoft.fidelity.service.OffreAchatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreAchatServiceImpl implements OffreAchatService {
    private final OffreAchatRepository offreAchatRepository;

    @Override
    public List<OffreAchat> getAllOffreAchat() {
        return offreAchatRepository.findAll();
    }

    @Override
    public OffreAchat getOffreAchatById(Long id) {
        return offreAchatRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        offreAchatRepository.deleteById(id);
    }

    @Override
    public OffreAchat save(OffreAchat offreAchat) {
        return offreAchatRepository.save(offreAchat);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(offreAchatRepository::deleteById);
    }
}
