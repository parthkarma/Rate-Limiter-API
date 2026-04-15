# 🚀 Rate Limiter API

A Spring Boot-based REST API that implements **Fixed Window Rate Limiting** to control request flow and prevent API abuse. Includes a simple frontend UI to test and visualize rate limiting behavior.

---

## 📌 Features

* ⏱ Fixed Window Rate Limiting (per IP)
* 🚫 Returns **HTTP 429 (Too Many Requests)** when limit exceeded
* 📊 Tracks request count per user/IP
* 🌐 Simple frontend UI for testing (HTML + JS)
* ⚡ Lightweight and easy to extend

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* REST APIs
* Maven
* HTML, CSS, JavaScript

---

## ⚙️ How It Works

* Each user (identified by IP) can make **limited requests per time window**
* Example:

  * Limit: **5 requests**
  * Time Window: **1 minute**
* After limit is exceeded:

  * API responds with:

    ```
    429 Too Many Requests
    ```

---

## 📡 API Endpoint

### Test API

```http
GET /api/test
```

### Response

✅ Success:

```
Request successful!
```

❌ Rate Limit Exceeded:

```
Too many requests
```

---

## 🖥 Frontend UI

Accessible at:

```
http://localhost:8080
```

### Features:

* Send single request
* Spam multiple requests
* View success vs blocked responses

---

## ▶️ Run Locally

### 1. Clone the repository

```bash
git clone https://github.com/parthkarma/rate-limiter-api.git
cd rate-limiter-api
```

### 2. Run the application

```bash
mvn spring-boot:run
```

### 3. Open in browser

```
http://localhost:8080
```

---

## 📁 Project Structure

```
com.ratelimiter.api
 ├── controller      # API endpoints
 ├── service         # Rate limiting logic
 ├── model           # Request tracking model
 ├── config          # Exception handling
 └── RateLimiterApiApplication
```

---

## 🔥 Future Improvements

* 🔁 Sliding Window Algorithm
* 🪣 Token Bucket Algorithm
* 🧠 Redis-based distributed rate limiter
* 🔐 User authentication-based limiting
* 📊 Dashboard with request analytics

---

## 👨‍💻 Author

**Parth**
GitHub: https://github.com/parthkarma

---

## ⭐ If you like this project

Give it a star ⭐ and share it!
