package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.response.DashboardClientResponse;
import com.arabsoft.fidelity.response.DashboardResponse;

public interface DashboardService {
    DashboardResponse getData();

    DashboardClientResponse getDataForClient(String identifiant);
}
