package com.arabsoft.fidelity.auth.service;

import com.arabsoft.fidelity.repository.ClientRepository;
import com.arabsoft.fidelity.repository.UserRepository;
import com.arabsoft.fidelity.auth.config.JwtUtils;
import com.arabsoft.fidelity.auth.request.AuthenticationRequest;
import com.arabsoft.fidelity.auth.request.ClientRequest;
import com.arabsoft.fidelity.auth.response.AuthenticationResponse;
import com.arabsoft.fidelity.exception.FidelityException;
import com.arabsoft.fidelity.model.Client;
import com.arabsoft.fidelity.model.User;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.arabsoft.fidelity.exception.ErrorMessageType.EMAIL_EXISTS;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final ClientRepository clientRepository;

    private final JwtUtils jwtUtils;

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        final User user = (User) authenticate.getPrincipal();
        if (user != null) {
            String jwt = jwtUtils.generateToken(user);
            Cookie cookie = new Cookie("jwt", jwt);
            cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
//                cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/"); // Global
            String identifiant = null;
            Optional<Client> client = clientRepository.findById(user.getId());
            if (client.isPresent())
                identifiant = client.get().getIdentifiant();
            return new AuthenticationResponse(jwt, user.getPrenom(), user.getNom(),identifiant,
                    user.getRole().contains("Admin"));
        }
        return null;
    }

    @Override
    public Optional<Client> addClient(ClientRequest client) throws Exception {
        if (userRepository.findByEmail(client.getEmail()).isPresent()) {
            throw new FidelityException("mail existe deja", EMAIL_EXISTS);
        }
        Client newClient = new Client();
        newClient.setPrenom(client.getPrenom());
        newClient.setNom(client.getNom());
        newClient.setEmail(client.getEmail());
        newClient.setPassword(new BCryptPasswordEncoder().encode(client.getPassword()));
        newClient.setAdresse(client.getAddress());
        newClient.setIdentifiant(client.getIdentifiant());
        newClient.setSexe(client.getGender());
        newClient.setDatenaiss(client.getBirthDate());
        newClient.setTel(client.getTel());
        newClient.setRole("Client");
        return Optional.of(clientRepository.save(newClient));
    }
}
