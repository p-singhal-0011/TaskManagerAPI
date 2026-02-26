# TaskManagerAPI 🚀

A secure, scalable, and production-ready REST API built using Spring Boot 3.
This project implements JWT authentication, role-based access control, structured exception handling, and pagination.

Developed as part of a Backend Developer Internship assignment.

## 🛠 Tech Stack

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JSON Web Token)
- Swagger (OpenAPI 3)
- Maven

---

## ✨ Key Features
### 🔐 Authentication & Security
- User Registration
- User Login
- Password hashing using BCrypt
- JWT token generation
- Stateless authentication (SessionCreationPolicy.STATELESS)
- Secure endpoint protection
- Ownership-based authorization
- Centralized exception handling
- Proper HTTP status codes (401, 403, 404, 400)

### 👥 Role-Based Access
- USER / ADMIN roles supported
- Protected APIs require valid JWT
- Task ownership validation (users can manage only their own tasks)

### 📝 Task Management (CRUD)
- Create Task
- Get Tasks (paginated & sorted)
- Delete Task (ownership validated)

Pagination supported via:

```http
GET /api/v1/tasks?page=0&size=5&sort=id,desc
```

---

## 🏗 Project Architecture

The project follows a clean layered architecture:

Controller → Service → Repository → Database
↓
Security Layer (JWT Filter)

Layers:
- Controller Layer – Handles HTTP requests
- Service Layer – Business logic
- Repository Layer – Database interaction
- Security Layer – JWT authentication & authorization
- Exception Layer – Centralized error handling system

---

## 🧠 Enterprise Enhancements Implemented

- Custom ApiException class
- Centralized ErrorCode enum
- Structured JSON error responses
- SecurityContext-based user extraction
- Ownership validation inside service layer
- Pagination and sorting support
- Stateless JWT-based architecture

---

## 🗄 Database Schema

### Users Table
- id (Primary Key)
- name
- email (Unique)
- password (Encrypted)
- role (USER / ADMIN)

### Tasks Table
- id (Primary Key)
- title
- description
- user_id (Foreign Key → Users)

---

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository
```http
git clone https://github.com/p-singhal-0011/TaskManagerAPI.git
cd TaskManagerAPI
```

### 2️⃣ Configure MySQL
```http
Create a database:
CREATE DATABASE taskmanager;
```
Update `application.properties`:
```http
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3️⃣ Run Application

Using Maven:
```http
mvn clean install
mvn spring-boot:run
```

Application will start on:
```http
http://localhost:8080
```

---

## 🔑 Authentication Flow

### 1️⃣ Register user
```http
POST /api/v1/auth/register
```
### 2️⃣ Login
```http
POST /api/v1/auth/login
```
### 3️⃣ Copy JWT token from response.

### 4️⃣ Use token in header:
```http
Authorization: Bearer <your_token>
```
### 5️⃣ Access protected endpoints:
```http
/api/v1/tasks
```

---

## 📘 Swagger Documentation

Swagger UI available at:
```http
http://localhost:8080/swagger-ui/index.html
```
Steps:
- Click Authorize
- Paste JWT token (without the word "Bearer")
- Execute protected endpoints

---

## 📬 Postman Collection

The Postman collection file is included:
```http
TaskManagerAPI.postman_collection.json
```
Import into Postman to test all APIs.

---

## 🔒 Security Implementation

- Stateless session management
- JWT validation filter
- BCrypt password encryption
- Secure SecurityFilterChain configuration
- Centralized exception handling
- Proper HTTP response codes
- Protection against unauthorized access

---

## 🚀 Scalability Considerations

- This project is designed with scalability in mind:
- Stateless JWT authentication enables horizontal scaling
- Clean layered architecture supports microservices transition
- Pagination support reduces large dataset load
- Database indexing can optimize performance
- Redis caching can be integrated
- Docker containerization ready
- Compatible with load balancers
- Can be extended to distributed authentication service

---

## 📌 API Endpoints Summary
### Authentication

POST `/api/v1/auth/register`

POST `/api/v1/auth/login`

### Task APIs (Protected)

GET `/api/v1/tasks`

POST `/api/v1/tasks`

DELETE `/api/v1/tasks/{id}`

## 👨‍💻 Author
### Priyansh Singhal
