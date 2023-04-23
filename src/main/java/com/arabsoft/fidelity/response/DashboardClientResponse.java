package com.arabsoft.fidelity.response;

import com.arabsoft.fidelity.model.HistoTransaction;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class DashboardClientResponse {

    private int totalPoints;
    private int numberPointsAddedPerMonth;
    private int numberPointsUsedPerMonth;
    private List<HistoTransaction> transactions;
}
