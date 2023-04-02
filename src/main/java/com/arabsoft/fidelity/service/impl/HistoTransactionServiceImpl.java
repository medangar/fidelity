package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.model.HistoTransaction;
import com.arabsoft.fidelity.repository.HistoTransactionRepository;
import com.arabsoft.fidelity.service.HistoTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoTransactionServiceImpl implements HistoTransactionService {
    private final HistoTransactionRepository histoTransactionRepository;

    public List<HistoTransaction> getAllHistoTransaction() {
        return histoTransactionRepository.findAll();
    }

    public HistoTransaction getHistoTransactionById(Long id) {
        return histoTransactionRepository.findById(id).get();
    }

    public void saveOrUpdate(HistoTransaction histoTransaction) {
        histoTransactionRepository.save(histoTransaction);
    }

    public void delete(Long id) {
        histoTransactionRepository.deleteById(id);
    }

    public void update(HistoTransaction histoTransaction) {
        histoTransactionRepository.save(histoTransaction);
    }
}
