package com.arabsoft.fidelity.auth.service;


import com.arabsoft.fidelity.auth.request.AuthenticationRequest;
import com.arabsoft.fidelity.auth.request.ClientRequest;
import com.arabsoft.fidelity.auth.response.AuthenticationResponse;
import com.arabsoft.fidelity.model.Client;

import java.util.Optional;

public interface AuthService {

    AuthenticationResponse authentication(AuthenticationRequest request);

    Optional<Client> addClient(ClientRequest client) throws Exception;
}
