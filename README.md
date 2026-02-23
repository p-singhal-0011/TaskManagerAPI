# TaskManagerAPI 🚀

A secure and scalable REST API built using **Spring Boot 3**, implementing:

- JWT Authentication
- Role-Based Access Control
- CRUD Operations
- Swagger API Documentation
- MySQL Database Integration

This project was developed as part of a Backend Developer Internship assignment.

---

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

## 📦 Features Implemented

### 🔐 Authentication
- User Registration
- User Login
- Password hashing using BCrypt
- JWT token generation
- Stateless authentication

### 👥 Role-Based Access
- USER / ADMIN roles supported
- Protected APIs require valid JWT
- Role-based authorization ready

### 📝 Task Management (CRUD)
- Create Task
- Get All Tasks
- Delete Task

### 📄 API Documentation
- Swagger UI available
- Postman collection included

---

## 🏗 Project Architecture

The project follows a layered architecture:
Controller → Service → Repository → Database
↓
Security Layer (JWT Filter)


### Layers:
- Controller Layer – Handles HTTP requests
- Service Layer – Business logic
- Repository Layer – Database interaction
- Security Layer – JWT authentication & authorization

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

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

### Layers:
- Controller Layer – Handles HTTP requests
- Service Layer – Business logic
- Repository Layer – Database interaction
- Security Layer – JWT authentication & authorization

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

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository
git clone https://github.com/p-singhal-0011/TaskManagerAPI.git


### 2️⃣ Configure MySQL

Create a database:
CREATE DATABASE taskmanager;


Update `application.properties` if needed:
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager
spring.datasource.username=root
spring.datasource.password=your_password



### 3️⃣ Run Application

Using Maven:
mvn clean install
mvn spring-boot:run


Application will start on:
http://localhost:8080


---

## 🔑 Authentication Flow

1. Register user:
   POST /api/v1/auth/register

2. Login:
   POST /api/v1/auth/login


3. Copy the JWT token from response.

4. Send token in header:
Authorization: Bearer <your_token>


5. Access protected endpoints:
   /api/v1/tasks

---

## 📘 Swagger Documentation

Access Swagger UI:
http://localhost:8080/swagger-ui/index.html


- Click "Authorize"
- Paste JWT token (without "Bearer")
- Test protected APIs directly

---

## 📬 Postman Collection

The Postman collection file is included in this repository:
TaskManagerAPI.postman_collection.json


Import it into Postman to test all APIs.

---

## 🔒 Security Implementation

- Stateless session management
- JWT token validation filter
- BCrypt password encryption
- Endpoint protection using Spring Security
- Role-based authorization support

---

## 🚀 Scalability Considerations

This project is designed keeping scalability in mind:

- Stateless JWT authentication allows horizontal scaling
- Layered architecture supports microservices conversion
- Database layer can be optimized with indexing & connection pooling
- Redis caching can be added for performance
- Docker containerization can be applied for cloud deployment
- Compatible with load balancers

---

## 📌 API Endpoints Summary

### Authentication
- POST `/api/v1/auth/register`
- POST `/api/v1/auth/login`

### Task APIs (Protected)
- GET `/api/v1/tasks`
- POST `/api/v1/tasks`
- DELETE `/api/v1/tasks/{id}`

---

## 👨‍💻 Author

Priyansh Singhal  
Backend Developer Intern Candidate

---

## 📎 Assignment Submission

This project fulfills the assignment requirements:

- Secure REST API
- JWT Authentication
- Role-Based Access
- CRUD Operations
- Swagger Documentation
- Postman Collection
- Scalability Notes
