package com.arabsoft.fidelity.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageType {

  EMAIL_EXISTS(1000, "email_exists"),
  COMPTE_NOT_FOUND(1001, "Compte_not_found"),
  NB_POINTS_INVALID(1002, "nb_points_invalid");

  private final int errorCode;
  private final String message;

}
