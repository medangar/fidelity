package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.exception.FidelityException;
import com.arabsoft.fidelity.model.HistoTransaction;
import com.arabsoft.fidelity.request.CommandRequest;

import java.util.List;

public interface TransactionService {

    HistoTransaction usePointFidelite(Long carteId, Float nbPoint) throws FidelityException;
    HistoTransaction addPointFidelite(CommandRequest request) throws FidelityException;


}
