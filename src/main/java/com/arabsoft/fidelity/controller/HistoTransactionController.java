package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.HistoTransaction;
import com.arabsoft.fidelity.service.HistoTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transactions")
public class HistoTransactionController {
    private final HistoTransactionService histoTransactionService;

    @GetMapping
    public List<HistoTransaction> getAllHistoTransactions() {
        return histoTransactionService.getAllHistoTransaction();
    }

    @GetMapping("/{id}")
    public HistoTransaction getHistoTransaction(@PathVariable(value = "id") Long id) {
        return histoTransactionService.getHistoTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHistoTransaction(@PathVariable(value = "id") Long id) {
        histoTransactionService.delete(id);
    }

    @PostMapping
    private int saveHistoTransaction(@RequestBody HistoTransaction histoTransaction) {
        histoTransactionService.saveOrUpdate(histoTransaction);
        return Math.toIntExact(histoTransaction.getId());
    }

    @PutMapping
    private HistoTransaction update(@RequestBody HistoTransaction histoTransaction) {
        histoTransactionService.saveOrUpdate(histoTransaction);
        return histoTransaction;
    }
}
