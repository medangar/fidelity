package com.arabsoft.fidelity.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {
//handle500 erreur serveur http w 400 erreur requete
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handle5xx(Exception exception) {

    ErrorResponse errorResponse = ErrorResponse.builder()
        .message(INTERNAL_SERVER_ERROR.getReasonPhrase())
        .httpStatus(INTERNAL_SERVER_ERROR)
        .build();
    log.error(exception.getMessage());
    exception.printStackTrace();
    return createResponseEntity(errorResponse);
  }
//badcredential maaneha adresse w mdp ghaltin
  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ErrorResponse> handleBadCredentialException(BadCredentialsException badCredentialsException, WebRequest request) {
    return getErrorResponse(badCredentialsException.getMessage());
  }

  @ExceptionHandler(FidelityException.class)
  public ResponseEntity<ErrorResponse> handleDomainException(FidelityException fidelityException, WebRequest request) {
    return getErrorResponse(fidelityException.getMessage());

  }

  private ResponseEntity<ErrorResponse> getErrorResponse(String message) {
    ErrorResponse errorResponse = ErrorResponse.builder()
        .message(message)
        .httpStatus(HttpStatus.BAD_REQUEST)
        .build();
    return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
  }

  private ResponseEntity<Object> createResponseEntity(ErrorResponse errorResponse) {
    return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
  }

}
