package com.arabsoft.fidelity.service.impl;

import com.arabsoft.fidelity.model.Client;
import com.arabsoft.fidelity.repository.ClientRepository;
import com.arabsoft.fidelity.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;


    public Client getClientById(Long id) {
        return clientRepository.findById((long) id).get();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(clientRepository::deleteById);
    }

    public void delete(Long id) {
        clientRepository.deleteById((long) id);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
}
