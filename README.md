
# 🧪 API Testing Documentation

## 📌 Base URLs

- **User Controller**: `http://localhost:8081/api/users`  
- **Activity Controller**: `http://localhost:8082/api/v1/activities`  

---

## 👤 User Controller Endpoints

### 1. Register a New User
- **Method**: `POST`  
- **URL**: `http://localhost:8081/api/users`  
- **Body (JSON)**:
  ```json
  {
    "username": "testuser",
    "email": "testuser@example.com",
    "password": "password123"
  }
  ```

---

### 2. Get User by ID
- **Method**: `GET`  
- **URL**: `http://localhost:8081/api/users/{id}`  
- **Description**: Replace `{id}` with the actual user ID.

---

### 3. Validate User
- **Method**: `GET`  
- **URL**: `http://localhost:8081/api/users/{userId}/validate`  
- **Description**: Replace `{userId}` with the actual user ID.

---

### 4. Delete User by ID
- **Method**: `DELETE`  
- **URL**: `http://localhost:8081/api/users/{id}`  
- **Description**: Replace `{id}` with the actual user ID.

---

### 5. Update User
- **Method**: `PUT`  
- **URL**: `http://localhost:8081/api/users/{id}`  
- **Body (JSON)**:
  ```json
  {
    "username": "updateduser",
    "email": "updateduser@example.com",
    "password": "newpassword123"
  }
  ```
- **Description**: Replace `{id}` with the actual user ID.

---

### 6. Get User by Email
- **Method**: `GET`  
- **URL**: `http://localhost:8081/api/users/email?email=testuser@example.com`  
- **Description**: Replace the email with the actual email you want to search.

---

### 7. Get All Users
- **Method**: `GET`  
- **URL**: `http://localhost:8081/api/users`

---

## 🏃‍♂️ Activity Controller Endpoints

### 1. Track a New Activity
- **Method**: `POST`  
- **URL**: `http://localhost:8082/api/v1/activities`  
- **Body (JSON)**:
  ```json
  {
    "activityType": "Running",
    "duration": 30,
    "distance": 5.0,
    "caloriesBurned": 300
  }
  ```

---

### 2. Get User Activities
- **Method**: `GET`  
- **URL**: `http://localhost:8082/api/v1/activities`  
- **Headers**:
  - `X-User-ID: userId123` *(Replace with actual user ID)*

---

### 3. Get Specific User Activity by ID
- **Method**: `GET`  
- **URL**: `http://localhost:8082/api/v1/activities/{activityId}`  
- **Description**: Replace `{activityId}` with the actual activity ID.

---

### 4. Get All Activities
- **Method**: `GET`  
- **URL**: `http://localhost:8082/api/v1/activities/all`

---

## 📝 Notes

- Ensure applications are running on the specified ports:
  - `8081` for User Controller
  - `8082` for Activity Controller
- Replace placeholders in URLs and request bodies with actual values.
- For `POST` and `PUT` methods, ensure JSON matches the structure expected by DTOs (`RegisterRequest`, `ActivityRequest`).


=----==---------------------====----------------------------------------------------------------------------------------------


# Microservices API Gateway - Endpoint Documentation

This document provides details on the exposed endpoints for the microservices routed via the API Gateway (port 8765).

---

## 🎯 Activity Service - `/api/v1/activities`

### ➕ Track Activity [POST]
- **URL**: `http://localhost:8765/api/v1/activities`
- **Headers**: `Content-Type: application/json`
- **Body**:
```json
{
  "userId": "user123",
  "activityType": "Running",
  "duration": 30,
  "distance": 5.0,
  "caloriesBurned": 250
}
```

### 📥 Get User Activities [GET]
- **URL**: `http://localhost:8765/api/v1/activities`
- **Headers**: `X-User-ID: user123`

### 🔍 Get Specific Activity [GET]
- **URL**: `http://localhost:8765/api/v1/activities/{activityId}`

### 📃 Get All Activities [GET]
- **URL**: `http://localhost:8765/api/v1/activities/all`

---

## 🧠 Recommendation Service - `/api/v1/recommendations`

### 📋 Get Recommendations for User [GET]
- **URL**: `http://localhost:8765/api/v1/recommendations/user123`

### 📊 Get Activity Recommendation [GET]
- **URL**: `http://localhost:8765/api/v1/recommendations/activity/{activityId}`

---

## 👤 User Service - `/api/users`

### ➕ Register User [POST]
- **URL**: `http://localhost:8765/api/users`
- **Body**:
```json
{
  "firstName": "Sandeep",
  "lastName": "Borkar",
  "email": "sandeep@example.com",
  "password": "securePassword123"
}
```

### 🔍 Get User by ID [GET]
- **URL**: `http://localhost:8765/api/users/{id}`

### ✅ Validate User [GET]
- **URL**: `http://localhost:8765/api/users/{userId}/validate`

### ❌ Delete User [DELETE]
- **URL**: `http://localhost:8765/api/users/{id}`

### ♻️ Update User [PUT]
- **URL**: `http://localhost:8765/api/users/{id}`
- **Body**:
```json
{
  "firstName": "Sandeep",
  "lastName": "Borkar",
  "email": "updated@example.com",
  "password": "newSecurePassword456"
}
```

### 🔎 Get User by Email [GET]
- **URL**: `http://localhost:8765/api/users/email?email=sandeep@example.com`

### 📚 Get All Users [GET]
- **URL**: `http://localhost:8765/api/users`

---
