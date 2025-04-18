
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
