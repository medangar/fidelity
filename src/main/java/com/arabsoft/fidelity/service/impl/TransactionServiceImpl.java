package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.exception.FidelityException;
import com.arabsoft.fidelity.model.Carte;
import com.arabsoft.fidelity.model.HistoTransaction;
import com.arabsoft.fidelity.model.OffreAchat;
import com.arabsoft.fidelity.model.OffreProduit;
import com.arabsoft.fidelity.repository.CarteRepository;
import com.arabsoft.fidelity.repository.HistoTransactionRepository;
import com.arabsoft.fidelity.repository.OffreAchatRepository;
import com.arabsoft.fidelity.repository.OffreProduitRepository;
import com.arabsoft.fidelity.request.CommandRequest;
import com.arabsoft.fidelity.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static com.arabsoft.fidelity.exception.ErrorMessageType.COMPTE_NOT_FOUND;
import static com.arabsoft.fidelity.exception.ErrorMessageType.NB_POINTS_INVALID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final CarteRepository carteRepository;

    private final HistoTransactionRepository histoTransactionRepository;

    private final OffreAchatRepository offreAchatRepository;
    private final OffreProduitRepository offreProduitRepository;

    @Override
    public HistoTransaction usePointFidelite(Long carteId, Float nbPoint) throws FidelityException {

        if (nbPoint == null || nbPoint <= 0) {
            throw new FidelityException("le nombre de point demandé doit etre superieur à zéro", NB_POINTS_INVALID);
        }
        Carte carte = carteRepository.findById(carteId)
                .orElseThrow(() -> new FidelityException("compte n'existe pas", COMPTE_NOT_FOUND));
        if (carte.getNbPoints() < nbPoint) {
            throw new FidelityException("votre solde est inferieur au nombre de point demandé", NB_POINTS_INVALID);
        }
        float newSolde = carte.getNbPoints() - nbPoint;
        HistoTransaction transaction = HistoTransaction.builder()
                .typeTransaction("crediteur")
                .carte(carte)
                .dateTransaction(LocalDate.now())
                .soldeFnl(newSolde)
                .soldeInit(carte.getNbPoints())
                .build();
        carte.setNbPoints(newSolde);
        histoTransactionRepository.save(transaction);
        carteRepository.save(carte);
        return transaction;
    }

    @Override
    public HistoTransaction addPointFidelite(CommandRequest request) throws FidelityException {
        Carte carte = carteRepository.findById(request.getCarteId())
                .orElseThrow(() -> new FidelityException("compte n'existe pas", COMPTE_NOT_FOUND));
        Long offreId = carte.getOffre().getId();
        Optional<OffreAchat> offreAchat = offreAchatRepository.getLastOffreAchatByOffreAndMinValue(offreId, request.getTotal()).stream().findFirst();
        List<OffreProduit> offreProduit = offreProduitRepository.getOffreProduitByOffre(offreId,request.getProductsIds());
        int sumOffreProduit = offreProduit.stream().flatMapToInt(x -> IntStream.of(x.getValeur())).sum();
        float newSolde = carte.getNbPoints() + offreAchat.get().getValeur() + sumOffreProduit;
        HistoTransaction transaction = HistoTransaction.builder()
                .typeTransaction("debiteur")
                .carte(carte)
                .dateTransaction(LocalDate.now())
                .soldeFnl(newSolde)
                .soldeInit(carte.getNbPoints())
                .build();
        carte.setNbPoints(newSolde);
        histoTransactionRepository.save(transaction);
        carteRepository.save(carte);
        return transaction;
    }

}
