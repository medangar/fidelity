package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.repository.CarteRepository;
import com.arabsoft.fidelity.repository.HistoTransactionRepository;
import com.arabsoft.fidelity.repository.UserRepository;
import com.arabsoft.fidelity.response.CarteByClient;
import com.arabsoft.fidelity.response.DashboardResponse;
import com.arabsoft.fidelity.response.StatPoint;
import com.arabsoft.fidelity.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final HistoTransactionRepository histoTransactionRepository;

    private final CarteRepository carteRepository;

    private final UserRepository userRepository;

    @Override
    public DashboardResponse getData() {

        return DashboardResponse.builder()
                .transactionPerDay(histoTransactionRepository.findTotalTransactionsPerDay(LocalDate.now(), LocalDate.now().plusDays(1)))
                .userPerDay(histoTransactionRepository.findUserTransactionPerDay(LocalDate.now(), LocalDate.now().plusDays(1)))
                .totalPoints(histoTransactionRepository.findTotalPointsPerDay(LocalDate.now(), LocalDate.now().plusDays(1)))
                .transactions(histoTransactionRepository.findLastTransactions())
                .statPoint(calculStatPoint())
                .nbTransactionHomme(histoTransactionRepository.getNumberTransactionBySexe("Homme"))
                .nbTransactionFemme(histoTransactionRepository.getNumberTransactionBySexe("Femme"))
                .users(userRepository.findUsersByRoles())
                .carteByClient(CarteByClient.builder()
                        .nbMoins18(countMoins18())
                        .nb18et30(count18To30())
                        .nb30et50(count30To50())
                        .nbPlus50(countPlus50())
                        .build())
                .build();
    }
    private int count30To50() {
        LocalDate now  = LocalDate.now();
        LocalDate max = now.minusYears(30);
        LocalDate min = now.minusYears(50);
        return carteRepository.countCarteByClientAndAge(min,max);
    }

    private int count18To30() {
        LocalDate now  = LocalDate.now();
        LocalDate max = now.minusYears(18);
        LocalDate min = now.minusYears(30);
        return carteRepository.countCarteByClientAndAge(min,max);
    }

    private int countMoins18() {
        LocalDate max = LocalDate.now();
        LocalDate min = max.minusYears(18);
        return carteRepository.countCarteByClientAndAge(min,max);
    }
    private int countPlus50() {
        LocalDate now = LocalDate.now();
        LocalDate max = now.minusYears(50);
        LocalDate min = max.minusYears(100);
        return carteRepository.countCarteByClientAndAge(min,max);
    }

    private StatPoint calculStatPoint() {
        LocalDate now = LocalDate.now();
        StatPoint stat = new StatPoint();
        for (int i = 6; i >= 0; i--) {
            calculStatPointByMonth(stat, now.minusMonths(i));
        }
        return stat;
    }

    private void calculStatPointByMonth(StatPoint stat, LocalDate date) {
        String nameOfMonth = date.getMonth().name();
        LocalDate start = date.withDayOfMonth(1);
        LocalDate end = date.with(lastDayOfMonth());
        Integer cumule = histoTransactionRepository.getTotalPtsByMonth("debiteur", start, end);
        Integer consomer = histoTransactionRepository.getTotalPtsByMonth("crediteur", start, end);
        stat.getMois().add(nameOfMonth);
        stat.getPointCumuler().add(cumule != null ? cumule : 0);
        stat.getPointConsommer().add(consomer != null ? consomer : 0);
    }
}
