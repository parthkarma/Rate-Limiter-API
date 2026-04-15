package com.ratelimiter.api.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(RuntimeException.class)
 @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
 public String handleRateLimitException(RuntimeException ex) {
  return ex.getMessage();
 }
}