package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.exception.FidelityException;
import com.arabsoft.fidelity.model.HistoTransaction;
import com.arabsoft.fidelity.request.CommandRequest;
import com.arabsoft.fidelity.request.UsePointRequest;
import com.arabsoft.fidelity.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/transaction")
@RequiredArgsConstructor
@RestController
public class TransactionController {

    private final TransactionService transactionService;


    @PostMapping
    public HistoTransaction usePointFidelite(@RequestBody UsePointRequest request) throws FidelityException {
        return transactionService.usePointFidelite(request.getCarteId(), request.getNbPoint());
    }

    @PostMapping("/ajouter")
    public HistoTransaction addPointFidelite(@RequestBody CommandRequest request) throws FidelityException {
        return transactionService.addPointFidelite(request);
    }

}
