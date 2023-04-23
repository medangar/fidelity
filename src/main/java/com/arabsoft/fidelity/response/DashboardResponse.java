package com.arabsoft.fidelity.response;

import com.arabsoft.fidelity.model.HistoTransaction;
import com.arabsoft.fidelity.model.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class DashboardResponse {

    private Integer userPerDay;
    private Integer transactionPerDay;
    private Integer totalPoints;
    private StatPoint statPoint;
    private List<HistoTransaction> transactions;
    private Integer nbTransactionHomme;
    private Integer nbTransactionFemme;
    private List<User> users;
    private CarteByClient carteByClient;
}
