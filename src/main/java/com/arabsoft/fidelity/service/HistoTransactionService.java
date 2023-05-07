package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.HistoTransaction;

import java.util.List;

public interface HistoTransactionService {

    List<HistoTransaction> getAllHistoTransaction();

    HistoTransaction getHistoTransactionById(Long id);

    void delete(Long id);

    void saveOrUpdate(HistoTransaction histoTransaction);

    List<HistoTransaction> getTransactionsByClientId(Long clientId);
}
