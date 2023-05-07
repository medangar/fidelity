package com.arabsoft.fidelity.auth.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String token;
  private String firstName;
  private String lastName;
  private String identifiant;
  private boolean isAdmin;
  private String role;
  private String gender;
  private Long id;
}
