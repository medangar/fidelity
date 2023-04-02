
package com.arabsoft.fidelity.auth.controller;

import com.arabsoft.fidelity.auth.request.AuthenticationRequest;
import com.arabsoft.fidelity.auth.request.ClientRequest;
import com.arabsoft.fidelity.auth.response.AuthenticationResponse;
import com.arabsoft.fidelity.auth.service.AuthService;
import com.arabsoft.fidelity.model.Client;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request, HttpServletResponse response) {
        System.err.println(request);
        return ResponseEntity.ok(authService.authentication(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Client> register(@RequestBody ClientRequest client) throws Exception {
        System.err.println(client);
        return ResponseEntity.ok(authService.addClient(client).orElseThrow(() -> new Exception("Unknown")));
    }

}

