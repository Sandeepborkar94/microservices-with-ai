# microservices-with-ai
integrating user and activity services with gemini ai free model

🧪 API Testing Documentation
📌 Base URLs

Controller	Base URL
User Controller	http://localhost:8081/api/users
Activity Controller	http://localhost:8082/api/v1/activities
👤 User Controller Endpoints
1. Register a New User
Method: POST

URL: http://localhost:8081/api/users

Body (JSON):

json
Copy
Edit
{
  "username": "testuser",
  "email": "testuser@example.com",
  "password": "password123"
}
2. Get User by ID
Method: GET

URL: http://localhost:8081/api/users/{id}

Note: Replace {id} with the actual user ID.

3. Validate User
Method: GET

URL: http://localhost:8081/api/users/{userId}/validate

Note: Replace {userId} with the actual user ID.

4. Delete User by ID
Method: DELETE

URL: http://localhost:8081/api/users/{id}

Note: Replace {id} with the actual user ID.

5. Update User
Method: PUT

URL: http://localhost:8081/api/users/{id}

Body (JSON):

json
Copy
Edit
{
  "username": "updateduser",
  "email": "updateduser@example.com",
  "password": "newpassword123"
}
Note: Replace {id} with the actual user ID.

6. Get User by Email
Method: GET

URL: http://localhost:8081/api/users/email?email=testuser@example.com

Note: Replace the email with the one you want to search for.

7. Get All Users
Method: GET

URL: http://localhost:8081/api/users

🏃‍♂️ Activity Controller Endpoints
1. Track a New Activity
Method: POST

URL: http://localhost:8082/api/v1/activities

Body (JSON):

json
Copy
Edit
{
  "activityType": "Running",
  "duration": 30,
  "distance": 5.0,
  "caloriesBurned": 300
}
2. Get User Activities
Method: GET

URL: http://localhost:8082/api/v1/activities

Headers:

X-User-ID: userId123
(Replace userId123 with the actual user ID)

3. Get Specific User Activity by ID
Method: GET

URL: http://localhost:8082/api/v1/activities/{activityId}

Note: Replace {activityId} with the actual activity ID.

4. Get All Activities
Method: GET

URL: http://localhost:8082/api/v1/activities/all

📝 Notes
Ensure both applications are running:

Port 8081 for User Controller

Port 8082 for Activity Controller

Replace placeholders in the URLs and request bodies with actual values.

For POST and PUT requests, ensure the JSON matches the expected DTOs (e.g., RegisterRequest, ActivityRequest).