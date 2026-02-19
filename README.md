TaskManagerAPI – Backend Developer Assignment
📌 Project Overview

TaskManagerAPI is a scalable RESTful backend application built using Spring Boot.
It implements secure authentication, role-based authorization, and CRUD operations for task management.

The project demonstrates clean architecture, secure API design, and scalability readiness.

🛠 Tech Stack

Java 21

Spring Boot 3.3.5

Spring Security

JWT (jjwt 0.11.5)

Spring Data JPA

MySQL

Swagger (OpenAPI 3)

Postman Collection

🔐 Authentication & Authorization

User Registration & Login

BCrypt password hashing

JWT-based stateless authentication

Role-based access control (USER / ADMIN)

Protected endpoints using SecurityFilterChain

📂 API Endpoints
Authentication APIs

POST /api/v1/auth/register

POST /api/v1/auth/login

Task APIs (JWT Required)

GET /api/v1/tasks

POST /api/v1/tasks

DELETE /api/v1/tasks/{id}

📄 API Documentation

Swagger UI available at:

http://localhost:8080/swagger-ui/index.html


Postman collection included in the repository.

🗄 Database Configuration

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager
spring.datasource.username=your_username
spring.datasource.password=your_password

▶️ Running the Application
mvn clean install
mvn spring-boot:run

📈 Scalability & Architecture Approach

The application follows a layered modular architecture:

Controller Layer (REST APIs)

Service Layer (Business Logic)

Repository Layer (Data Access)

Security Layer (JWT + RBAC)

Scalability Enhancements (Future Ready)

Stateless Authentication
JWT enables horizontal scaling without session storage.

Microservices Ready
Authentication and Task modules can be separated into independent services.

Caching
Redis can be integrated for frequently accessed data.

Load Balancing
Multiple instances can be deployed behind a load balancer (e.g., Nginx).

Containerization
Application can be Dockerized and deployed via Kubernetes.

Centralized Logging & Monitoring
Integration with ELK stack or Prometheus/Grafana.

The architecture supports horizontal scalability and cloud-native deployment.

👨‍💻 Author

Priyansh Singhal