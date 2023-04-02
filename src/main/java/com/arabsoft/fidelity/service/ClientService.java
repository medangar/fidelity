package com.arabsoft.fidelity.service;

import com.arabsoft.fidelity.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClient();

    Client getClientById(Long id);

    void delete(Long id);

    Client save(Client client);

    void delete(List<Long> ids);
}
