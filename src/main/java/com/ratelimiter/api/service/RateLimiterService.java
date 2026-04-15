package com.ratelimiter.api.service;

import com.ratelimiter.api.model.UserRequestInfo;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {

 private final ConcurrentHashMap<String, UserRequestInfo> requestCounts = new ConcurrentHashMap<>();

 private static final int LIMIT = 5;
 private static final long WINDOW_SIZE = 60 * 1000; // 1 min

 public boolean allowRequest(String userId) {

  long currentTime = System.currentTimeMillis();

  requestCounts.putIfAbsent(userId, new UserRequestInfo(0, currentTime));

  UserRequestInfo info = requestCounts.get(userId);

  if (currentTime - info.getWindowStart() > WINDOW_SIZE) {
   info.setCount(1);
   info.setWindowStart(currentTime);
   return true;
  }

  if (info.getCount() < LIMIT) {
   info.setCount(info.getCount() + 1);
   return true;
  }

  return false;
 }
}