package com.arabsoft.fidelity.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageType {

  EMAIL_EXISTS(1000, "email_exists");

  private final int errorCode;
  private final String message;

}
