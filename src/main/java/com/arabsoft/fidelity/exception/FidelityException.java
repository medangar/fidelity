package com.arabsoft.fidelity.exception;

import lombok.Getter;

@Getter
public class FidelityException extends Exception {

  private final ErrorMessageType errorMessageType;


  public FidelityException(String message,ErrorMessageType errorMessageType) {
    super(message);
    this.errorMessageType=errorMessageType;
  }
}
