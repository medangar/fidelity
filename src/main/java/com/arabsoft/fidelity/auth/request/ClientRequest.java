package com.arabsoft.fidelity.auth.request;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClientRequest {
    private String prenom;
    private String nom;
    private String identifiant;
    private String email;
    private String password;
    private String gender;
    private String address;
    private int codePostal;
    private String tel;
    private LocalDate birthDate;

}
