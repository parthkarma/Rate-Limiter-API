package com.ratelimiter.api.controller;

import com.ratelimiter.api.service.RateLimiterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
public class TestController {

 private final RateLimiterService rateLimiterService;

 public TestController(RateLimiterService rateLimiterService) {
  this.rateLimiterService = rateLimiterService;
 }

 @GetMapping("/api/test")
 public String test(HttpServletRequest request) {

  String userIp = request.getRemoteAddr();

  if (!rateLimiterService.allowRequest(userIp)) {
   throw new RuntimeException("Too many requests");
  }

  return "Request successful!";
 }
}