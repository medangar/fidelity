package com.arabsoft.fidelity.controller;

import com.arabsoft.fidelity.model.Client;
import com.arabsoft.fidelity.request.DeleteRequest;
import com.arabsoft.fidelity.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/client")
@RequiredArgsConstructor
@RestController
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable(value = "id") Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    private Client saveClient(@RequestBody Client client) {
        System.err.println(client);
        return clientService.save(client);
    }

    @PutMapping
    private Client update(@RequestBody Client client) {
        System.err.println(client);
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable(value = "id") Long id) {
        clientService.delete(id);
    }
    @DeleteMapping
    public void deleteClients(@RequestBody DeleteRequest userIds) {
        clientService.delete(userIds.getIds());
    }
}
